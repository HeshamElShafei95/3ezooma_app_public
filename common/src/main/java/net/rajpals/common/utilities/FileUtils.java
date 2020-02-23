package net.rajpals.common.utilities;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.webkit.MimeTypeMap;

import net.rajpals.common.logger.AppLogger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static net.rajpals.common.logger.AppLogger.Logger.error;


public class FileUtils {

    public static final String IMAGE_FILE_PREFIX = "renturcar_1_0";
    public static final int FULL_IMAGE_WIDTH = 768;
    public static final int FULL_IMAGE_HEIGHT = 1024;
    public static final int THUMBNAIL_WIDTH = 170;
    public static final int THUMBNAIL_HEIGHT = 270;
    private static final String TAG = FileUtils.class.getName();
    private static String UPLOAD_IMAGE = "Upload image";
    private static int imageCompressPercentage = 60;
    private static long MAX_SIZE = 2;

    //GET SCALED BIT MAP : This technique allows you to read the dimensions and type of the image data prior to construction (and memory allocation) of the bitmap.
    public static Bitmap getBitmapImages(@NonNull final String imagePath, final int requiredWidth, final int requiredHeight) {
        AppLogger.Logger.debug(TAG, "Get bitmap from given imagePath : " + imagePath + " - reqWidth : " + requiredWidth + " - reqHeight :  " + requiredHeight);
        //INITIALIZE THE BIT OBJECT TO NULL
        // OPTION TO DECODE BITMAP
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            InputStream is = new FileInputStream(imagePath);
            BitmapFactory.decodeStream(is, null, options);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        options.inScaled = true;
        //Setting the inJustDecodeBounds property to true while decoding avoids memory allocation,
        options.inJustDecodeBounds = true;
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, requiredWidth, requiredHeight);
        options.inJustDecodeBounds = false;
        // Decode bitmap with inSampleSize set
        return BitmapFactory.decodeFile(imagePath, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    // Save Image bitmap to App directory.
    public static String saveBitmapAsFileToExternalCard(@NonNull Bitmap bitmap, @NonNull String newFileName, @NonNull String path) {
        FileOutputStream fo = null;
        try {
            String fullFilePath = path + newFileName;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, imageCompressPercentage, stream);
            byte[] byteArray = stream.toByteArray(); // convert camera photo to byte array

            // save it in your external storage.
            fo = new FileOutputStream(new File(fullFilePath));
            fo.write(byteArray);
            fo.flush();
            fo.close();
            return fullFilePath;
        } catch (IOException | SecurityException ex) {
            error(TAG, ex.getMessage(), ex);
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException ex) {
                    error(TAG, ex.getMessage(), ex);
                }
            }
        }
        return null;
    }

    //Get Image path from gallery  : By intent URI
    // Save Image bitmap to App directory.
    public static String getGalleryImagePathFromUri(@NonNull Uri selectedImage, Context context) throws NullPointerException {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }

    // Generating Unique File Name from date format
    public static String getUniqueFileName(String imagePrefix) {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = imagePrefix + "_" + timeStamp + "_" + getUniqueIdLong() + ".jpg";
        return imageFileName;
    }

    @NonNull
    private static String getUniqueIdLong() {
        Random r = new Random();
        long systemTime = System.currentTimeMillis();
        long uniqueTime = (long) (systemTime + r.nextDouble() * 60 * 60 * 24 * 365);
        return String.valueOf(uniqueTime);
    }


    public static byte[] toByteArray(Bitmap raw) {
        byte[] byteArray = null;
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            raw.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byteArray = stream.toByteArray();
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
        }
        return byteArray;
    }


    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(@NonNull String input) {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    public static boolean isFileExist(@NonNull String path) {
        File myDirectory = new File(path);
        return myDirectory.exists();
    }

    public static boolean removeFile(String path) {
        File file = null;
        if (!path.isEmpty()) {
            try {
                file = new File(URI.create(path));
                if (file.exists())
                    file.delete();
            } catch (IllegalArgumentException ex) {
                AppLogger.Logger.error(TAG, ex.getMessage());
            }
        }
        return true;
    }


    public static boolean deleteFile(@NonNull String path) {
        try {
            File myDirectory = new File(path);
            return myDirectory.delete();
        } catch (Exception e) {
            AppLogger.Logger.error(TAG, e.getMessage(), e);
        }
        return false;
    }

    // get image size and compare it with MAX_SIZE
    static boolean isValidSizeBitmap(String path) {
        File file = new File(path);
        // Get length of file in bytes
        long fileSizeInBytes = file.length();
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        long fileSizeInKB = fileSizeInBytes / 1024;
        // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        long fileSizeInMB = fileSizeInKB / 1024;
        if (fileSizeInMB > MAX_SIZE)
            return false;
        return true;
    }


    @Nullable
    public static File createTempImageFile(String fileName, Context context) {
        try {
            File storageDir = context.getExternalFilesDir(null);
            return new File(storageDir, fileName);
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
        }
        return null;
    }

    static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    public static void persistImage(Bitmap bitmap, File imageFile) {
        persistImage(bitmap, imageFile, Bitmap.CompressFormat.PNG);
    }

    public static void persistImage(Bitmap bitmap, File imageFile, Bitmap.CompressFormat format) {

        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(format, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e(TAG, "Error writing bitmap", e);
        }
    }

    public static boolean copyFile(File sourceLocation, File targetLocation) {


        // just to take note of the location sources
        Log.v(TAG, "sourceLocation: " + sourceLocation);
        Log.v(TAG, "targetLocation: " + targetLocation);
        try {
            // make sure the target file exists
            if (sourceLocation.exists()) {
                InputStream in = new FileInputStream(sourceLocation);
                OutputStream out = new FileOutputStream(targetLocation);
                // Copy the bits from instream to outstream
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                Log.v(TAG, "Copy file successful.");
                return true;
            } else {
                Log.v(TAG, "Copy file failed. Source file missing.");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void persistImageAsync(Bitmap bitmap, File imageFile, Bitmap.CompressFormat format, OnTaskCompleteListener onTaskCompleteListener) {

        new PersistImageAsyncTask(bitmap, imageFile, format, onTaskCompleteListener).execute();


    }

    public static String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }

    public static boolean isGif(String mimeType) {
        return MimeUtils.isGif(mimeType);
    }

    public interface OnTaskCompleteListener {
        void onTaskComplete(File file, String error);
    }

    static class PersistImageAsyncTask extends AsyncTask<Void, Void, String> {
        private final Bitmap mBitmap;
        private final File mImageFile;
        private final Bitmap.CompressFormat mFormat;
        private final OnTaskCompleteListener mOnTaskCompleteListener;

        PersistImageAsyncTask(Bitmap bitmap, File imageFile, Bitmap.CompressFormat format, OnTaskCompleteListener onTaskCompleteListener) {

            mBitmap = bitmap;
            mImageFile = imageFile;
            mFormat = format;
            mOnTaskCompleteListener = onTaskCompleteListener;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                //create a file to write bitmap data
                if (!mImageFile.createNewFile()) {
                    return null;
                }
                //Convert bitmap to byte array
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                mBitmap.compress(mFormat, 100, bos);
                byte[] bitmapData = bos.toByteArray();

                //write the bytes in file
                FileOutputStream fos = new FileOutputStream(mImageFile);
                fos.write(bitmapData);
                fos.flush();
                fos.close();

            } catch (Exception e) {
                Log.e(TAG, "Error writing bitmap", e);
                return null;
            }
            return mImageFile.getAbsolutePath();
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            if (mOnTaskCompleteListener != null) {
                mOnTaskCompleteListener.onTaskComplete(mImageFile, aVoid);
            }
        }
    }
}
