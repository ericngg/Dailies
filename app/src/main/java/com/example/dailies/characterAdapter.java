package com.example.dailies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class characterAdapter extends RecyclerView.Adapter<characterAdapter.ViewHolder>  {

    List<Character> characterList;
    Context context;
    onCharacterListener onCharacterListener;

    public characterAdapter(List<Character> characterList, Context context, onCharacterListener onCharacterListener) {
        this.characterList = characterList;
        this.context = context;
        this.onCharacterListener = onCharacterListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.character, parent, false), onCharacterListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(characterList.get(position));
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvName;
        onCharacterListener onCharacterListener;

    public ViewHolder(@NonNull View itemView, onCharacterListener onCharacterListener) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.onCharacterListener = onCharacterListener;

            itemView.setOnClickListener(this);
        }

        public void bind(Character character) {
            tvName.setText(character.getName());
        }

        @Override
        public void onClick(View v) {
            onCharacterListener.onCharacterClick(getAdapterPosition());
        }
    }

    public interface onCharacterListener {
        void onCharacterClick(int position);
    }
}
