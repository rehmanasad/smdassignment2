import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assign2.R;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    ArrayList<item> itemlist;
    public itemAdapter(ArrayList<item> list)
    {
        itemlist = new ArrayList<>();
        itemlist.addAll(list);
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.single_item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvloc.setText(itemlist.get(position).getLoc());
        holder.tvRname.setText(itemlist.get(position).getName());
        holder.tvdes.setText(itemlist.get(position).getDes());
        holder.tvphone.setText(itemlist.get(position).getPhone());
        holder.rating.setText(itemlist.get(position).getrating()+"");
    }

    public void updateList(ArrayList<item> newList) {
        itemlist.clear(); // Clear the current list
        itemlist.addAll(newList); // Add new items
        notifyDataSetChanged(); // Notify adapter of the change
    }


    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvRname, tvloc, tvdes, tvphone, rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRname = itemView.findViewById(R.id.tvItemName);
            rating = itemView.findViewById(R.id.tvRating);
            tvloc = itemView.findViewById(R.id.tvprop1);
            tvphone = itemView.findViewById(R.id.tvprop2);
            tvdes = itemView.findViewById(R.id.tvprop3);


        }
    }
}