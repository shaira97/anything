package unsw.Infs3605.Mydegree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class year1_pageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public year1_pageAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                Term1 term1 = new Term1();
                return term1;

            case 1:
                Term2 term2 = new Term2();
                return term2;

            case 2:
                Term3 term3 = new Term3();
                return term3;
            default:
                return null;
        }
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;

    }

    @Override
    public int getCount() {

        return 3;
    }
}

