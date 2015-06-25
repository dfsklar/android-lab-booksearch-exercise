package com.codepath.android.booksearch.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.BookItemViewHolder>
{
    private List<Book> books;

    //constructor
    public BookRecyclerAdapter(final List<Book> books)
    {
        this.books = books;
    }

    //onCreateViewHolder gets the ViewHolder used for the item at given position
    @Override
    public BookItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_book, viewGroup, false);
        return new BookItemViewHolder(itemView);
    }

    //onBindViewHolder is called when views need to be created from given ViewHolder
    @Override
    public void onBindViewHolder(BookItemViewHolder bookItemViewHolder, int position) {
        Book book = books.get(position);
        bookItemViewHolder.tvTitle.setText(book.getTitle());
        bookItemViewHolder.tvAuthor.setText(book.getAuthor());
        bookItemViewHolder.ivCover.setImageURI(Uri.parse(book.getCoverUrl()));
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

    // This is the ViewHolder
    public class BookItemViewHolder extends RecyclerView.ViewHolder
    {
        public SimpleDraweeView ivCover;
        public TextView tvTitle;
        public TextView tvAuthor;

        public BookItemViewHolder(View itemView) {
            super(itemView);
            ivCover = (SimpleDraweeView) itemView.findViewById(R.id.ivBookCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
        }
    }

    // This method is used to update data for adapter and notify adapter that data has changed
    public void updateList(List<Book> data) {
        books = data;
        notifyDataSetChanged();
    }
}