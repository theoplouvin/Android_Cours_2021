package com.example.td5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        contacts.add(new Contact("Théo", "Plouvin", "https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("Rénald", "Plouvin", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Poster-sized_portrait_of_Barack_Obama.jpg/1200px-Poster-sized_portrait_of_Barack_Obama.jpg"));
        contacts.add(new Contact("Enzo", "Plouvin", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Louis_XIV_of_France.jpg/330px-Louis_XIV_of_France.jpg"));
        contacts.add(new Contact("Gauthier", "Leurette","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Hyacinthe_Rigaud_-_Louis_de_France%2C_Dauphin_%281661-1711%29%2C_dit_le_Grand_Dauphin_-_Google_Art_Project.jpg/300px-Hyacinthe_Rigaud_-_Louis_de_France%2C_Dauphin_%281661-1711%29%2C_dit_le_Grand_Dauphin_-_Google_Art_Project.jpg"));
        contacts.add(new Contact("Toto", "XX","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Mademoiselle_de_Tours_%28Louise_Marie_Anne_de_Bourbon%29_by_Pierre_Mignard_%28Versaiilles%29.jpg/300px-Mademoiselle_de_Tours_%28Louise_Marie_Anne_de_Bourbon%29_by_Pierre_Mignard_%28Versaiilles%29.jpg"));
        contacts.add(new Contact("Vero", "LOU","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("Pierre", "Pierre","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Louis_XIV_of_France.jpg/330px-Louis_XIV_of_France.jpg"));
        contacts.add(new Contact("George", "DASH","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("ETH", "PLS","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Louis_XIV_of_France.jpg/330px-Louis_XIV_of_France.jpg"));
        contacts.add(new Contact("COU", "TO","https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));

        ContactsAdapter adapter = new ContactsAdapter(contacts);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}
