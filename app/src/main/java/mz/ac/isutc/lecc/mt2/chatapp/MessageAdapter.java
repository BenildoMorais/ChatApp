package mz.ac.isutc.lecc.mt2.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private Context context;
    private List<MessageModel> messageModelList;

    public MessageAdapter(Context context) {
        this.context = context;
        messageModelList = new ArrayList<>();
    }

    public void add(MessageModel messageModel){
        messageModelList.add(messageModel);
        notifyDataSetChanged();
    }

    public void clear(){
        messageModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MessageModel messageModel = messageModelList.get(position);

        if(messageModel.getSenderId().equals(FirebaseAuth.getInstance().getUid())){
            holder.main2.setVisibility(View.GONE);
            holder.msg.setText(messageModel.getMessage());
        }else{
            holder.main.setVisibility(View.GONE);
            holder.msg2.setText(messageModel.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView msg;
        private TextView msg2;

        private  LinearLayout main;
        private  LinearLayout main2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            msg = itemView.findViewById(R.id.message_sent); //41.11 - antes era messageEd

            msg2 = itemView.findViewById(R.id.message_recieved); //41.11 - antes era messageEd

            main = itemView.findViewById(R.id.mainMessage_sent_Layout);
            main2 = itemView.findViewById(R.id.mainMessage_recieved_Layout);
        }
    }

}
