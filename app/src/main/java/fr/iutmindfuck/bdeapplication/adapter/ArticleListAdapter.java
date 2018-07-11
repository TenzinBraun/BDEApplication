package fr.iutmindfuck.bdeapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import fr.iutmindfuck.bdeapplication.data.Article;


public class ArticleListAdapter extends ArrayAdapter<Article> {
    public ArticleListAdapter(@NonNull Context context, int resource, ArrayList<Article> articles) {
        super(context,0,articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
