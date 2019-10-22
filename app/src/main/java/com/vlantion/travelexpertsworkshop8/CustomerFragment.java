package com.vlantion.travelexpertsworkshop8;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vlantion.travelexpertsworkshop8.Customer.Customer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;


public class CustomerFragment extends Fragment {
    View myView;
    ListView lvCustomers;
    StringBuffer buffer = new StringBuffer();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lvCustomers = myView.findViewById(R.id.lvCustomers);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false);
    }
    class GetCustomers extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("http://10.163.112.170:8080/Group2JSP/rest/booking/getbooking/105"); // TODO: CHANGE (FROM ECLIPSE) - ENDPOINT
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String json;
                while ((json = br.readLine()) != null) {
                    buffer.append(json);
                }
                br.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            ArrayAdapter<Customer> adapter = new ArrayAdapter<Booking>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1);
//            //Toast.makeText(getActivity().getApplicationContext(), buffer.toString(), Toast.LENGTH_LONG).show();
//            try {
//                JSONArray jsonArray = new JSONArray(buffer.toString());
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject book = jsonArray.getJSONObject(i);
//                    Customer customer = new Customer(book.getInt("customerId"), new java.util.Date(book.getString("bookingDate")),
//                            book.getString("bookingNo"), book.getInt("customerId"), book.getInt("packageId"),
//                            book.getDouble("travelerCount"), book.getString("tripTypeId")
//                    ); // TODO: CHANGE THIS
//
//                    adapter.add(customer);
//                }
//                lvCustomers.setAdapter(adapter);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

            JSONObject jObj = null;
            String json = "";


            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try{
                        URL url = new URL("http://10.0.2.2:8080/Workshop/rs/customer/getallcustomers");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        //conn.setRequestMethod("GET");
                        //conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                        // conn.setRequestProperty("Accept","application/json");
                        //conn.setDoOutput(true);
                        //conn.setDoInput(true);

                        InputStream iS = conn.getInputStream();
                        InputStreamReader reader = new InputStreamReader(iS);
                        BufferedReader bufferedReader = new BufferedReader((reader));
                        String line;
                        ArrayList<Customer> customerList = new ArrayList<Customer>();


                        // Save server response text.
                        StringBuffer readTextBuf = new StringBuffer();

                        line = bufferedReader.readLine();
                        Log.d("GET: ", line);



                        JSONArray customers = new JSONArray(line);

                        //Loop through all contacts

                        for (int i =0; i < customers.length(); i++){
                            JSONObject c = customers.getJSONObject(i);
                            int customerId = c.getInt("customerId");
                            String custFirstName = c.getString("custFirstName");
                            String custLastName = c.getString("custLastName");
                            String custAddress = c.getString("custAddress");
                            String custCity = c.getString("custCity");
                            String custProv = c.getString("custProv");
                            String custPostal = c.getString("custPostal");
                            String custCountry = c.getString("custCountry");
                            String custHomePhone = c.getString("custHomePhone");
                            String custBusPhone = c.getString("custBusPhone");
                            String custEmail = c.getString("custEmail");
                            int agentId = c.getInt("agentId");

                            Customer customer = new Customer(customerId, custFirstName,
                                    custLastName, custAddress,
                                    custCity,  custProv,
                                    custPostal,custCountry,
                                    custHomePhone,  custBusPhone,
                                    custEmail, agentId);

                            customerList.add(customer);
                            Log.d("LOOP: ", customerList.get(i).getCustFirstName());
                        }


                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();
        }
    }

}
