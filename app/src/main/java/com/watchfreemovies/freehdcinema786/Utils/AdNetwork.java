package com.watchfreemovies.freehdcinema786.Utils;

import android.app.Activity;
import android.widget.LinearLayout;

import com.applovin.mediation.ads.MaxInterstitialAd;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.watchfreemovies.freehdcinema786.Config.UiConfig;
import com.watchfreemovies.freehdcinema786.R;

public class AdNetwork {

    private final Activity context;
    int counter = 1;
    private int retry = 0;
    private MaxInterstitialAd interstitialAd;
    /*Unity ads*/
    String BannerID = "Banner_Android";
    String InterstitialID = "Interstitial_Android";
    LinearLayout bannerAd;

    public AdNetwork(Activity context) {
        this.context = context;
        //find id
    }

    /*Unity Ads*/
    public void loadUnityBannerAd(){
        bannerAd = context.findViewById(R.id.banner_ad);
        BannerView view = new BannerView(context,BannerID,new UnityBannerSize(320,50));
        view.load();
        bannerAd.addView(view);
    }
    public void loadUnityInterstitialAd() {
        if (UnityAds.isInitialized()){
            IUnityAdsLoadListener iUnityAdsLoadListener = new IUnityAdsLoadListener() {
                @Override
                public void onUnityAdsAdLoaded(String s) {

                }

                @Override
                public void onUnityAdsFailedToLoad(String s, UnityAds.UnityAdsLoadError unityAdsLoadError, String s1) {

                }
            };
            UnityAds.load(InterstitialID,iUnityAdsLoadListener);

        }
    }
    public void showUnityInterstitialAd() {
        if (UiConfig.INTERSTITIAL__AD_VISIBILITY) {
            IUnityAdsShowListener iUnityAdsShowListener = new IUnityAdsShowListener() {
                @Override
                public void onUnityAdsShowFailure(String s, UnityAds.UnityAdsShowError unityAdsShowError, String s1) {

                }

                @Override
                public void onUnityAdsShowStart(String s) {

                }

                @Override
                public void onUnityAdsShowClick(String s) {

                }

                @Override
                public void onUnityAdsShowComplete(String s, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {

                }
            };
            UnityAds.show(context,InterstitialID, new UnityAdsShowOptions(), iUnityAdsShowListener);
        }
    }
    //show Interstitial ad count click
    public void showUnityInterstitialAdCount() {
        if (UiConfig.INTERSTITIAL__AD_VISIBILITY) {
            IUnityAdsShowListener iUnityAdsShowListener = new IUnityAdsShowListener() {
                @Override
                public void onUnityAdsShowFailure(String s, UnityAds.UnityAdsShowError unityAdsShowError, String s1) {

                }

                @Override
                public void onUnityAdsShowStart(String s) {

                }

                @Override
                public void onUnityAdsShowClick(String s) {

                }

                @Override
                public void onUnityAdsShowComplete(String s, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {

                }
            };
            if (counter == UiConfig.INTERSTITIAL_AD_INTERVAL) {
                UnityAds.show(context,InterstitialID, new UnityAdsShowOptions(), iUnityAdsShowListener);
                counter = 1;
            } else {
                counter++;
            }
        }
    }

    /*Applovin Ads*/
    /*//load banner ad
    public void loadBannerAd() {
        MaxAdView adView = new MaxAdView(context.getString(R.string.banner_ad_unit_id), context);
        MaxAdView bannerAd = context.findViewById(R.id.adView);
        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                bannerAd.setVisibility(View.GONE);
                adView.loadAd();
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                bannerAd.setVisibility(View.GONE);
                adView.loadAd();
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                bannerAd.setVisibility(View.GONE);
                adView.loadAd();
            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = context.getResources().getDimensionPixelSize(R.dimen.banner_height);

        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        adView.setBackgroundColor(Color.TRANSPARENT);
        bannerAd.addView(adView);
        adView.loadAd();
        adView.startAutoRefresh();
    }
    //load MREC ad
    public void loadMrecAd() {
        MaxAdView MRECAdview = new MaxAdView(context.getString(R.string.mrec_ad_unit_id), context);
        MaxAdView mRecAd = context.findViewById(R.id.mRec);
        MRECAdview.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                mRecAd.setVisibility(View.GONE);
                MRECAdview.loadAd();
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                mRecAd.setVisibility(View.GONE);
                MRECAdview.loadAd();
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                mRecAd.setVisibility(View.GONE);
                MRECAdview.loadAd();
            }
        });

        int width = AppLovinSdkUtils.dpToPx(context, 300);
        int height = AppLovinSdkUtils.dpToPx(context, 250);

        MRECAdview.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        MRECAdview.setBackgroundColor(Color.TRANSPARENT);
        mRecAd.addView(MRECAdview);
        MRECAdview.loadAd();
        MRECAdview.startAutoRefresh();

    }
    //load Interstitial ad
    public void loadInterstitialAd() {
        interstitialAd = new MaxInterstitialAd(context.getString(R.string.interstitial_ad_unit_id), context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                retry = 0;
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                interstitialAd.loadAd();
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                retry++;
                long delay = TimeUnit.SECONDS.toMillis((long) Math.pow(2, Math.min(6, retry)));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        interstitialAd.loadAd();
                    }
                }, delay);
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                interstitialAd.loadAd();
            }
        };

        interstitialAd.setListener(adListener);
        interstitialAd.loadAd();
    }

    //show Interstitial ad count click
    public void showInterstitialAdCount() {
        if (UiConfig.INTERSTITIAL__AD_VISIBILITY) {
            if (interstitialAd.isReady()) {
                if (counter == UiConfig.INTERSTITIAL_AD_INTERVAL) {
                    interstitialAd.showAd();
                    counter = 1;
                } else {
                    counter++;
                }
            }
        }
    }

    //show Interstitial ad without count click
    public void showInterstitialAd() {
        if (UiConfig.INTERSTITIAL__AD_VISIBILITY) {
            if (interstitialAd.isReady()) {
                interstitialAd.showAd();
            }
        }
    }*/
}
