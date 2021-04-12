package com.goodautodeal.goodautodeal.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.FragmentNavigationDrawerBinding;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.SpecialSharedPrefHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.views.activities.LoginActivity;
import com.goodautodeal.goodautodeal.views.adapters.NavigationDrawerAdapter;
import com.goodautodeal.goodautodeal.views.models.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bilal Zaman on 18/02/21.
 */
public class FragmentNavigationDrawer extends Fragment {
    private static final Integer[] imgDrawer = {R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon,
            R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon,
            R.drawable.car_icon, R.drawable.car_icon, R.drawable.car_icon,  R.drawable.car_icon};
    private static String[] titles = null;
    @Inject
    UIHelper uiHelper;
    private FragmentNavigationDrawerBinding binding;
    private FragmentDrawerListener drawerListener;
    private Context context;
    private NavigationDrawerAdapter adapter;
    private DrawerLayout drawerLayout;
    private View containerView;
    private ActionBarDrawerToggle mDrawerToggle;

    public FragmentNavigationDrawer() {
        // Required empty public constructor
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<NavDrawerItem>();

        int len = titles.length;

        // preparing navigation drawer items
        for (int i = 0; i < len; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            navItem.setImgItem(imgDrawer[i]);

            data.add(navItem);
        }
        return data;
    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_navigation_drawer, container, false);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        View view = binding.getRoot();
        View parentLayout = view.findViewById(R.id.mainLayout);
        parentLayout.setOnClickListener(null);

        setNavigationRecyclerView();

        binding.btnLoginAsDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivityAndSendValue(getActivity(), LoginActivity.class, "dealer");
            }
        });

//        binding.imgLoginProvider.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (PreferenceHelper.getInstance().getString(ConstUtils.isLogin, ConstUtils.no).equalsIgnoreCase(ConstUtils.yes)) {
//                    Toast.makeText(context, getResources().getString(R.string.currently_login_as_user),
//                            Toast.LENGTH_SHORT).show();
////                    uiHelper.openActivity(getActivity(), ProviderMainActivity.class);
//                } else {
//                    uiHelper.openActivityAndSendValue(getActivity(), LoginActivity.class, "mapActivity");
//                }
//
//                drawerLayout.closeDrawer(GravityCompat.START);
////                 uiHelper.openActivity(getActivity(), ProviderMainActivity.class);
//            }
//        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (PreferenceHelper.getInstance().getString(ConstUtils.USER_NAME,"") != null) {
            binding.txtUser.setText(PreferenceHelper.getInstance().getString(ConstUtils.USER_NAME,""));
            Glide.with(context).load(R.drawable.ic_baseline_person_24).into(binding.imgUser);
        } else {
            binding.txtUser.setText(R.string.guest_user);
        }
    }

    private void setNavigationRecyclerView() {
        adapter = new NavigationDrawerAdapter(getActivity(), getData());
        binding.recyclerviewNavigation.setAdapter(adapter);

        binding.recyclerviewNavigation.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                binding.recyclerviewNavigation, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                // Toast.makeText(context, "position: "+position, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void setUp(int fragmentId, DrawerLayout mdrawerLayout) {
        containerView = getActivity().findViewById(fragmentId);
        drawerLayout = mdrawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (getActivity() != null)
                    getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (getActivity() != null)
                    getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        drawerLayout.setDrawerListener(mDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private final GestureDetector gestureDetector;
        private final ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
