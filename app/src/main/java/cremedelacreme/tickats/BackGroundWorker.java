package cremedelacreme.tickats;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class BackGroundWorker extends AsyncTask<String,Void,String> {

    private TextView textView;
    Context context;


    BackGroundWorker (Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String login_url = "https://tickats.live/login.php";
        String update_location_url = "https://tickats.live/updatelocation.php";
                        //For my (Jeramy's) screen
        String HeavyEquipment_URL = "https://tickats.live/DisplayHeavyEquipment.php";
        String LightEquipment_URL = "https://tickats.live/DisplayLightEquipment.php";
        String WorkerInfo_URL = "https://tickats.live/DisplayWorkerInfo.php";
        String HeaderInfo_URL = "https://tickats.live/DisplayDataWorksiteLocation.php";


        if (type.equals("login")) {

            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("TicketDetails")){
            try{
                String fwid = params[1];
                URL url = new URL(HeavyEquipment_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8" ));
                //Next Line differs****************************88
                String post_data = URLEncoder.encode("fwid", "UTF-8") + "=" + URLEncoder.encode(fwid, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) !=null ){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();
                return result;

            }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

            //My (Jeramy) background worker begin
        else if(type.equals("HeavyEquip")){
            try{
                String TID = params[1];
                //String TID = params[2];
                URL url = new URL(HeavyEquipment_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("TID", "UTF-8") + "=" + URLEncoder.encode(TID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                JSONObject Job = new JSONObject(result);
                JSONArray HEdata = Job.getJSONArray("Heavy Equipment");
                for(int i =0; i<HEdata.length(); i++) {
                    JSONObject HE = HEdata.getJSONObject(i);
                    String HEid = HE.getString("Heavy Equipment ID");
                    String Model = HE.getString("Equipment Description");
                    String status =HE.getString("Equipment Status");
                    TicketDetails.mArr1.add(HEid);
                    TicketDetails.mArr2.add(Model);
                    TicketDetails.mArr3.add(status);
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();

                return result;
                }
                catch (MalformedURLException e) {
                e.printStackTrace(); }
                catch (IOException e) {
                e.printStackTrace(); }
                catch (JSONException e) {
                e.printStackTrace(); }
                                            }

        else if (type.equals("LightEquip")){
            try{
                String TID = params[1];
                URL url = new URL(LightEquipment_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("TID", "UTF-8") + "=" + URLEncoder.encode(TID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                JSONObject Job = new JSONObject(result);
                JSONArray LEdata = Job.getJSONArray("Light Equipment");
                for(int i =0; i<LEdata.length(); i++) {
                    JSONObject LE = LEdata.getJSONObject(i);
                    String LEid = LE.getString("Light Equipment ID");
                    String Model = LE.getString("Equipment Description");
                    String status = LE.getString("Equipment Status");
                    TicketDetails.mArr4.add(LEid);
                    TicketDetails.mArr5.add(Model);
                    TicketDetails.mArr6.add(status);
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();

                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace(); }
            catch (IOException e) {
                e.printStackTrace(); }
            catch (JSONException e) {
                e.printStackTrace(); }
        }


        else if (type.equals("Workers")){
            try{
                String TID = params[1];
                URL url = new URL(WorkerInfo_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("TID", "UTF-8") + "=" + URLEncoder.encode(TID, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                JSONObject Job = new JSONObject(result);
                JSONArray Wdata = Job.getJSONArray("Worker");
                for(int i =0; i<Wdata.length(); i++) {
                    JSONObject HE = Wdata.getJSONObject(i);
                    String Fname = HE.getString("First Name");
                    String Lname = HE.getString("Last Name");
                    String Pnumber = HE.getString("Phone Number");
                    TicketDetails.mArr7.add(Fname);
                    TicketDetails.mArr8.add(Lname);
                    TicketDetails.mArr9.add(Pnumber);
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();

                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace(); }
            catch (IOException e) {
                e.printStackTrace(); }
            catch (JSONException e) {
                e.printStackTrace(); }
        }

        else if (type.equals("JobsiteHeader")){
            try{
                String WorkerName = params[1];
                //URL below incorrect.
                URL url = new URL(WorkerInfo_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("WorkerName", "UTF-8") + "=" + URLEncoder.encode(WorkerName, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }}
        return null;
    }

}