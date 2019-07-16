package unsw.Infs3634.Mydegree;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Course> courseList;
    Dialog dialog;
    Toast toast;
    CourseDatabaseHelper dbHelper;

    public RecyclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.courseList = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.activity_cardview_course, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        dbHelper = new CourseDatabaseHelper(mContext);
        Course course = courseList.get(position);
        holder.courseTitle.setText(course.getCourseTitle());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (courseList.get(position).getIsEnabled() == 1) {
                    final int tabNumber = year1_mgmtActivity.getTabNumber();
                    //toast.makeText(mContext,"Y1 Tab No: " +tabNumber,Toast.LENGTH_SHORT).show();
                    dialog = new Dialog(mContext);
                    dialog.setContentView(R.layout.activity_course_clicked);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    final TextView courseTitle = (TextView) dialog.findViewById(R.id.courseTitle);
                    TextView courseDescription = (TextView) dialog.findViewById(R.id.courseDescription);
                    TextView assessmentStructure = (TextView) dialog.findViewById(R.id.assessmentStructure);
                    final String course = courseList.get(position).getCourseTitle();
                    courseTitle.setText(course);
                    courseDescription.setText(courseList.get(position).getCourseDescription());
                    assessmentStructure.setText(courseList.get(position).getAssessmentStructure());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();


                    Button addButton = (Button) dialog.findViewById(R.id.addButton);
                    addButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick (View v) {
                            int tabNumber = year1_mgmtActivity.getTabNumber();
                            dbHelper.updateIsCompleted(course);
                            if (tabNumber == 0){
                                String termSelected = "T1";
                                dbHelper.updateTerm(course,termSelected);
                                Term1.adapter.notifyDataSetChanged();
                                Term1.adapter2.notifyDataSetChanged();
                                Term1.adapter3.notifyDataSetChanged();
                                Term1.adapter4.notifyDataSetChanged();
                                Term1.adapter5.notifyDataSetChanged();
                                Term1.adapter6.notifyDataSetChanged();
                                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(0);
                                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.detach(fragment);
                                fragmentTransaction.attach(fragment);
                                fragmentTransaction.commit();
//                                int tabNumber2 = CourseOverviewY2.getTabNumber();
                                //toast.makeText(mContext,"Tab No: " +tabNumber2,Toast.LENGTH_SHORT).show();

                            }else if (tabNumber == 1){
                                String termSelected = "T2";
                                dbHelper.updateTerm(course,termSelected);
                                Term2.adapter.notifyDataSetChanged();
                                Term2.adapter2.notifyDataSetChanged();
                                Term2.adapter3.notifyDataSetChanged();
                                Term2.adapter4.notifyDataSetChanged();
                                Term1.adapter5.notifyDataSetChanged();
                                Term1.adapter6.notifyDataSetChanged();
                                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(1);
                                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.detach(fragment);
                                fragmentTransaction.attach(fragment);
                                fragmentTransaction.commit();

                            }else if (tabNumber == 2) {
                                String termSelected = "T3";
                                dbHelper.updateTerm(course,termSelected);
                                Term3.adapter.notifyDataSetChanged();
                                Term3.adapter2.notifyDataSetChanged();
                                Term3.adapter3.notifyDataSetChanged();
                                Term3.adapter4.notifyDataSetChanged();
                                Term1.adapter5.notifyDataSetChanged();
                                Term1.adapter6.notifyDataSetChanged();
                                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(1);

                                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.detach(fragment);
                                fragmentTransaction.attach(fragment);
                                fragmentTransaction.commit();
                            }

                            dialog.dismiss();
                        }
                    });

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });
                } else {
                    dialog = new Dialog(mContext);
                    dialog.setContentView(R.layout.activity_course_error);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    TextView courseError = (TextView) dialog.findViewById(R.id.courseError);
                    courseError.setText(courseList.get(position).getCourseError());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView courseTitle;
        ImageView courseImage;
        CardView cardview;

        public MyViewHolder(View itemView) {

            super(itemView);
            courseTitle = (TextView) itemView.findViewById(R.id.courseTitle);
            courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            cardview = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }

}

