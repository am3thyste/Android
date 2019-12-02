import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.budgetapp.R;

public class SimpleAdapter extends BaseAdapter {
    public Context mContext;
    private LayoutInflater layoutInflater;
    private TextView title, description;
    private String[] titleArray, descriptionArray;
    private ImageView imageView;


   public SimpleAdapter(Context context, String[] title, String [] description){
            mContext= context;
            titleArray=title;
            descriptionArray= description;
            layoutInflater= LayoutInflater.from(context);
        }



    @Override
    public int getCount(){
        return titleArray.length;
    }

    @Override
    public Object getItem(int position) {
        return  titleArray[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            layoutInflater.inflate(R.layout.main_activity_single_item, null);
        }
        title= convertView.findViewById(R.id.tvMain);
        description = convertView.findViewById(R.id.tvDescription);
        imageView = convertView.findViewById(R.id.ivMain);

        title.setText(titleArray[position]);
        description.setText(descriptionArray[position]);

        if(titleArray[position].equalsIgnoreCase("Timetable")){
            imageView.setImageResource(R.drawable.timetable);
        }else if(titleArray[position].equalsIgnoreCase("Subjects")){
            imageView.setImageResource(R.drawable.book);
        }else if(titleArray[position].equalsIgnoreCase("Faculty")) {
            imageView.setImageResource(R.drawable.play);
        }else{
             imageView.setImageResource(R.drawable.settings);
            }
    return convertView;
    }
}
