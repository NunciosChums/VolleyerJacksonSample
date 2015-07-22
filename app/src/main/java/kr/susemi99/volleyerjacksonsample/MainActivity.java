package kr.susemi99.volleyerjacksonsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.navercorp.volleyextensions.volleyer.Volleyer;


public class MainActivity extends Activity
{
  private TextView textResult;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textResult = (TextView) findViewById(R.id.textView);

    findViewById(R.id.button1).setOnClickListener(clickListener);
    findViewById(R.id.button2).setOnClickListener(clickListener);
    findViewById(R.id.button3).setOnClickListener(clickListener);
    findViewById(R.id.button4).setOnClickListener(clickListener);
  }

  private void callJackson1()
  {
    Volleyer.volleyer().get("http://test.susemi99.kr/jackson1.json").withTargetClass(MyItem.class).withListener(listener1).withErrorListener(errorListener).execute();
  }

  private void callJackson2()
  {
    Volleyer.volleyer().get("http://test.susemi99.kr/jackson2.json").withTargetClass(MyItem[].class).withListener(listener2).withErrorListener(errorListener).execute();
  }

  private void callJackson3()
  {
    Volleyer.volleyer().get("http://test.susemi99.kr/jackson3.json").withTargetClass(MyItems.class).withListener(listener3).withErrorListener(errorListener).execute();
  }

  private void callJackson4()
  {
    Volleyer.volleyer().get("http://test.susemi99.kr/jackson4.json").withTargetClass(MyItemParent.class).withListener(listener4).withErrorListener(errorListener).execute();
  }

  private View.OnClickListener clickListener = new View.OnClickListener()
  {
    @Override
    public void onClick(View view)
    {
      int id = view.getId();
      if (id == R.id.button1)
        callJackson1();
      else if (id == R.id.button2)
        callJackson2();
      else if (id == R.id.button3)
        callJackson3();
      else if (id == R.id.button4)
        callJackson4();
    }
  };

  private Response.Listener<MyItem> listener1 = new Response.Listener<MyItem>()
  {
    @Override
    public void onResponse(MyItem item)
    {
      textResult.setText("==== jackson1 ====\n");
      textResult.append(item.name + ", " + item.url);
    }
  };

  private Response.Listener<MyItem[]> listener2 = new Response.Listener<MyItem[]>()
  {
    @Override
    public void onResponse(MyItem[] items)
    {
      textResult.setText("==== jackson2 ====\n");

      for (MyItem item : items)
      {
        textResult.append(item.name + ", " + item.url + "\n");
      }
    }
  };

  private Response.Listener<MyItems> listener3 = new Response.Listener<MyItems>()
  {
    @Override
    public void onResponse(MyItems myItems)
    {
      textResult.setText("==== jackson3 ====\n");

      for (MyItem item : myItems.items)
      {
        textResult.append(item.name + ", " + item.url + "\n");
      }
    }
  };

  private Response.Listener<MyItemParent> listener4 = new Response.Listener<MyItemParent>()
  {
    @Override
    public void onResponse(MyItemParent myItemParent)
    {
      textResult.setText("==== jackson4 ====\n");
      textResult.append(myItemParent.item.name + ", " + myItemParent.item.url + "\n");
    }
  };

  private Response.ErrorListener errorListener = new Response.ErrorListener()
  {
    @Override
    public void onErrorResponse(VolleyError error)
    {
      textResult.setText(error.getLocalizedMessage());
    }
  };
}
