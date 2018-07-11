package fr.iutmindfuck.bdeapplication.manager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import fr.iutmindfuck.bdeapplication.R;
import fr.iutmindfuck.bdeapplication.data.Article;

public class ArticleSQLManager extends ArrayAdapter<Article> {

    public ArticleSQLManager(@NonNull Context context, ArrayList<Article> articles ) {
        super(context,0,articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.default_list_item, parent, false);
        }

        initView(convertView, position);
        setRemoveClickListener(convertView, position);
        setModifyClickListener(convertView, position);
        setQuestionsClickListener(convertView, position);

        return convertView;
    }

    private void initView(View convertView, int position) {

    }
}
