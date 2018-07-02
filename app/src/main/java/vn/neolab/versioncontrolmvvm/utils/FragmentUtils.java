package vn.neolab.versioncontrolmvvm.utils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import vn.neolab.versioncontrolmvvm.ui.base.BaseActivity;
import vn.neolab.versioncontrolmvvm.ui.base.BaseFragment;

public class FragmentUtils {

    public static void replaceFragmentInActivity(BaseActivity activity,
                                                 Class<? extends BaseFragment> claz,
                                                 int id, boolean addToBackStack, Bundle arg) {
        replaceFragment(activity, claz, null, id, addToBackStack, arg);
    }


    public static void replaceFragmentInFragment(Class<? extends BaseFragment> claz,
                                                 Fragment parentFragment,
                                                 int id, boolean addToBackStack, Bundle arg) {
        replaceFragment(null, claz, parentFragment, id, addToBackStack, arg);
    }

    private static void replaceFragment(BaseActivity activity, Class<? extends BaseFragment> claz,
                                        Fragment parentFragment,
                                        int id, boolean addToBackStack, Bundle arg) {
        if (isFragmentShown(activity, claz, id, parentFragment)) {
            return;
        }

        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = parentFragment != null ?
                parentFragment.getChildFragmentManager().beginTransaction() :
                activity.getSupportFragmentManager().beginTransaction();

        Fragment newFragment;
        try {
            newFragment = claz.newInstance();
            if (arg != null) newFragment.setArguments(arg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        }

        if (addToBackStack) ft.addToBackStack(null);
        ft.replace(id, newFragment, claz.getClass().getSimpleName());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commitAllowingStateLoss();
    }

    private static boolean isFragmentShown(BaseActivity activity, Class<? extends BaseFragment> claz,
                                           int id, Fragment parentFragment) {
        Fragment curFragment = parentFragment != null ?
                parentFragment.getChildFragmentManager().findFragmentById(id) :
                activity.getSupportFragmentManager().findFragmentById(id);

        return (curFragment == null && claz == null) || (curFragment != null && claz.isInstance(curFragment));

    }
}
