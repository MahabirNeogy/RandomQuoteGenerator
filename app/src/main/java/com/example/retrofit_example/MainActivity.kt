package com.example.retrofit_example

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button:Button=findViewById(R.id.button)
        button.setOnClickListener {
            val call = RetrofitClient.quoteApiService.getRandomQuote()

            call.enqueue(object : Callback<List<Quote>> {

                override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {

                    if (response.isSuccessful) {

                        val quotes = response.body()

// Handle the list of quotes

// Example: Display the first quote's content

                        if (quotes != null && quotes.isNotEmpty()) {

                            val tv:TextView=findViewById(R.id.textView)
                            val tv2:TextView=findViewById(R.id.textView2)

                            val quoteContent = quotes[0].content
                            val quoteAuthor = quotes[0].author
                            Log.d("================",quoteContent)

                            tv.text=quoteContent
                            tv2.text="- "+quoteAuthor


// Display or use the quote content as needed

                        }

                    } else {

// Handle error

                    }

                }

                override fun onFailure(call: Call<List<Quote>>, t: Throwable) {

// Handle failure

                }

            })
        }


    }
}