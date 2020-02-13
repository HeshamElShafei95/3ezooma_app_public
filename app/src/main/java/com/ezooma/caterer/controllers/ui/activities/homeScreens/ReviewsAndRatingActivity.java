package com.ezooma.caterer.controllers.ui.activities.homeScreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ezooma.caterer.R;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvOrderItemsAdapter;
import com.ezooma.caterer.controllers.ui.adapters.rvAdapters.RvReviewsAndRatingsAdapter;

public class ReviewsAndRatingActivity extends AppCompatActivity {
    RecyclerView mRvReviewsAndRatings;
    RvReviewsAndRatingsAdapter mRvReviewsAndRatingsAdapter;
AppCompatTextView mTxtToolbarTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_and_rating);
        initVariables();
        setUpRv();
    }

    private void setUpRv() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRvReviewsAndRatings.setLayoutManager(layoutManager);
        mRvReviewsAndRatings.setItemAnimator(new DefaultItemAnimator());
        mRvReviewsAndRatingsAdapter = new RvReviewsAndRatingsAdapter(this);
        mRvReviewsAndRatings.setAdapter(mRvReviewsAndRatingsAdapter);

    }

    private void initVariables() {
        mTxtToolbarTitle=findViewById(R.id.txtToolbarTitle);
        mRvReviewsAndRatings = findViewById(R.id.rvReviewsAndRatings);
    mTxtToolbarTitle.setText("Reviews and ratings");
    }
}
