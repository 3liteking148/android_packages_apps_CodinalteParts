package com.meticulus.codinalteparts.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.meticulus.codinalteparts.app.FunctionsMain;

public class MainActivity extends Activity {

    TextView kernel,networking,workarounds,performance,charger,debugging; /* Headers */

    Switch venturi_variant, sweep2wake, doubletap2wake, bln, blnblink, otg, /* Kernel */
            googledns, rdm_wlan_mac, /* Networking */
            clockfreeze, incallaudio, bttether, h264softdec, /* Workarounds */
            cpu2, LMKNKP, /* Performance */
            charger_show_datetime, charger_no_suspend, /* Charger */
            autologcat, autokmsg, autoril; /* Debugging */

    ImageView whatis_venturi_variant, whatis_sweep2wake, whatis_doubletap2wake, whatis_bln, whatis_blnblink, whatis_otg, /* Kernel */
            whatis_googledns, whatis_rdm_wlan_mac,/* Networking */
            whatis_clockfreeze, whatis_incallaudio, whatis_bttether, whatis_h264softdec, /* Workarounds */
            whatis_cpu2, whatis_LMKNKP, /* Performance */
            whatis_charger_show_datetime, whatis_charger_no_suspend, /* Charger */
            whatis_autologcat,whatis_autokmsg, whatis_autorillog; /* Debugging */

    LinearLayout venturi_variant_layout, sweep2wake_layout, doubletap2wake_layout, bln_layout, blnblink_layout, otg_layout, /* Kernel */
            googledns_layout, rdm_wlan_mac_layout,/* Networking */
            clockfreeze_layout, incallaudio_layout, bttether_layout, h264softdec_layout, /* Workarounds */
            cpu2_layout, LMKNKP_layout, /* Performance */
            charger_show_datetime_layout, charger_no_suspend_layout, /* Charger */
            autologcat_layout, autokmsg_layout, autoril_layout; /* Debugging */

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.xml.activity_main);

        /* Headers */
        kernel = (TextView) findViewById(R.id.kernel_textview);
        networking = (TextView) findViewById(R.id.network_textview);
        workarounds = (TextView) findViewById(R.id.workarounds_texview);
        performance = (TextView) findViewById(R.id.performance_textview);
        charger = (TextView) findViewById(R.id.charger_textview);
        debugging = (TextView) findViewById(R.id.debugging_textview);

        /* Assign all switches */
        venturi_variant = (Switch) findViewById((R.id.switch_venturi_variant));
        sweep2wake = (Switch) findViewById((R.id.switch_sweep2wake));
        doubletap2wake = (Switch) findViewById((R.id.switch_doubletap2wake));
        bln = (Switch) findViewById((R.id.switch_bln));
        blnblink = (Switch) findViewById((R.id.switch_blnblink));
        otg = (Switch) findViewById((R.id.switch_otg));
        rdm_wlan_mac = (Switch)findViewById((R.id.switch_rdm_wlan_mac));
        googledns = (Switch) findViewById(R.id.switch_googledns);
        clockfreeze = (Switch) findViewById(R.id.switch_clockfreeze);
        incallaudio = (Switch) findViewById(R.id.switch_incallaudio);
        bttether = (Switch) findViewById(R.id.switch_bttether);
        h264softdec = (Switch) findViewById(R.id.switch_h264softdec);
        cpu2 = (Switch) findViewById(R.id.switch_cpu2);
        LMKNKP = (Switch) findViewById(R.id.switch_LMKNKP);
        charger_show_datetime = (Switch) findViewById(R.id.switch_charger_show_datetime);
        charger_no_suspend = (Switch) findViewById(R.id.switch_charger_no_suspend);
        autologcat = (Switch) findViewById(R.id.switch_autologcat);
        autokmsg = (Switch) findViewById(R.id.switch_autokmsg);
        autoril = (Switch)findViewById(R.id.switch_autorillog);

        /* Assign all switches onCheckChanged*/
        venturi_variant.setOnCheckedChangeListener(switchListener);
        sweep2wake.setOnCheckedChangeListener(switchListener);
        doubletap2wake.setOnCheckedChangeListener(switchListener);
        bln.setOnCheckedChangeListener(switchListener);
        blnblink.setOnCheckedChangeListener(switchListener);
        otg.setOnCheckedChangeListener(switchListener);
        googledns.setOnCheckedChangeListener(switchListener);
        rdm_wlan_mac.setOnCheckedChangeListener(switchListener);
        clockfreeze.setOnCheckedChangeListener(switchListener);
        incallaudio.setOnCheckedChangeListener(switchListener);
        bttether.setOnCheckedChangeListener(switchListener);
        h264softdec.setOnCheckedChangeListener(switchListener);
        cpu2.setOnCheckedChangeListener(switchListener);
        LMKNKP.setOnCheckedChangeListener(switchListener);
        charger_show_datetime.setOnCheckedChangeListener(switchListener);
        charger_no_suspend.setOnCheckedChangeListener(switchListener);
        autologcat.setOnCheckedChangeListener(switchListener);
        autokmsg.setOnCheckedChangeListener(switchListener);
        autoril.setOnCheckedChangeListener(switchListener);

        whatis_venturi_variant = (ImageView) findViewById(R.id.whatis_venturi_variant);
        whatis_venturi_variant.setOnClickListener(switchClickListener);

        whatis_doubletap2wake = (ImageView) findViewById(R.id.whatis_doubletap2wake);
        whatis_doubletap2wake.setOnClickListener(switchClickListener);

        whatis_sweep2wake = (ImageView) findViewById(R.id.whatis_sweep2wake);
        whatis_sweep2wake.setOnClickListener(switchClickListener);

        whatis_bln = (ImageView) findViewById(R.id.whatis_bln);
        whatis_bln.setOnClickListener(switchClickListener);

        whatis_blnblink = (ImageView) findViewById(R.id.whatis_blnblink);
        whatis_blnblink.setOnClickListener(switchClickListener);
        
	whatis_otg = (ImageView) findViewById(R.id.whatis_otg);
        whatis_otg.setOnClickListener(switchClickListener);

        whatis_googledns = (ImageView) findViewById(R.id.whatis_googledns);
        whatis_googledns.setOnClickListener(switchClickListener);

        whatis_rdm_wlan_mac = (ImageView) findViewById(R.id.whatis_rdm_wlan_mac);
        whatis_rdm_wlan_mac.setOnClickListener(switchClickListener);

        whatis_clockfreeze = (ImageView) findViewById(R.id.whatis_clockfreeze);
        whatis_clockfreeze.setOnClickListener(switchClickListener);

        whatis_incallaudio = (ImageView) findViewById(R.id.whatis_incallaudio);
        whatis_incallaudio.setOnClickListener(switchClickListener);

        whatis_bttether = (ImageView) findViewById(R.id.whatis_bttether);
        whatis_bttether.setOnClickListener(switchClickListener);

        whatis_h264softdec = (ImageView) findViewById(R.id.whatis_h264softdec);
        whatis_h264softdec.setOnClickListener(switchClickListener);

        whatis_charger_show_datetime = (ImageView) findViewById(R.id.what_is_charger_show_datetime);
        whatis_charger_show_datetime.setOnClickListener(switchClickListener);

        whatis_charger_no_suspend = (ImageView) findViewById(R.id.what_is_charger_no_suspend);
        whatis_charger_no_suspend.setOnClickListener(switchClickListener);

        whatis_cpu2 = (ImageView) findViewById(R.id.whatis_cpu2);
        whatis_cpu2.setOnClickListener(switchClickListener);

        whatis_LMKNKP = (ImageView) findViewById(R.id.whatis_LMKNKP);
        whatis_LMKNKP.setOnClickListener(switchClickListener);

        whatis_autologcat = (ImageView) findViewById(R.id.whatis_autologcat);
        whatis_autologcat.setOnClickListener(switchClickListener);

        whatis_autokmsg = (ImageView) findViewById(R.id.whatis_autokmsg);
        whatis_autokmsg.setOnClickListener(switchClickListener);

        whatis_autorillog = (ImageView) findViewById(R.id.whatis_autorillog);
        whatis_autorillog.setOnClickListener(switchClickListener);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        venturi_variant_layout = (LinearLayout) findViewById(R.id.venturi_variant_layout);
        sweep2wake_layout = (LinearLayout) findViewById(R.id.sweep2wake_layout);
        doubletap2wake_layout = (LinearLayout) findViewById(R.id.doubletap2wake_layout);
        bln_layout = (LinearLayout) findViewById(R.id.bln_layout);
        blnblink_layout = (LinearLayout) findViewById(R.id.blnblink_layout);
        rdm_wlan_mac_layout = (LinearLayout) findViewById(R.id.rdm_wlan_mac_layout);
        googledns_layout = (LinearLayout) findViewById(R.id.googledns_layout);
        clockfreeze_layout = (LinearLayout) findViewById(R.id.clockfreeze_layout);
        incallaudio_layout = (LinearLayout) findViewById(R.id.incallaudio_layout);
        bttether_layout = (LinearLayout) findViewById(R.id.bttether_layout);
        h264softdec_layout = (LinearLayout) findViewById(R.id.h264softdec_layout);
        charger_show_datetime_layout = (LinearLayout) findViewById(R.id.charger_show_datetime_layout);
        charger_no_suspend_layout = (LinearLayout) findViewById(R.id.charger_no_suspend_layout);
        cpu2_layout = (LinearLayout) findViewById(R.id.CPU2_layout);
        LMKNKP_layout = (LinearLayout) findViewById(R.id.LMKNKP_layout);

        prepareUI();

        String device =  "";
        try {
            device = SystemProperties.get("ro.build.product");
            //device = CommandUtility.ExecuteShellCommandTrimmed("getprop ro.build.product", true, false);
            Log.i("Codinalte Parts", "Device = '" + device + "'" );
        }
        catch(Exception ex){ex.printStackTrace();}

        /* disable for all, patches disabled */
        clockfreeze_layout.setVisibility(View.GONE);
        h264softdec_layout.setVisibility(View.GONE);
        if(device.equals("YP-G70")){

            clockfreeze_layout.setVisibility(View.GONE);
            incallaudio_layout.setVisibility(View.GONE);
            /*h264softdec_layout.setVisibility(View.GONE);*/

            performance.setVisibility(View.GONE);
            cpu2_layout.setVisibility(View.GONE);
            LMKNKP_layout.setVisibility(View.GONE);
        }
        else if(device.equals("m470")){

            venturi_variant_layout.setVisibility(View.GONE);
            bln_layout.setVisibility(View.GONE);
            blnblink_layout.setVisibility(View.GONE);

            workarounds.setVisibility(View.GONE);
            bttether_layout.setVisibility(View.GONE);
            /*h264softdec_layout.setVisibility(View.GONE);*/
            clockfreeze_layout.setVisibility(View.GONE);
            incallaudio_layout.setVisibility(View.GONE);

            performance.setVisibility(View.GONE);
            cpu2_layout.setVisibility(View.GONE);
            LMKNKP_layout.setVisibility(View.GONE);


        }
        else if(device.equals("codinamtr") || device.equals("codinavid") || device.equals("codinatmo")) {

            venturi_variant_layout.setVisibility(View.GONE);
        }

    }

    private void prepareUI(){

        String varcode = FunctionsMain.getVenturiVariantCode();
        venturi_variant.setChecked(varcode.equals("XAA") || varcode.equals("XAC"));
        doubletap2wake.setChecked(sharedPref.getBoolean("doubletap2wake", getResources().getBoolean(R.bool.doubletap2wake_default_enabled)));
        sweep2wake.setChecked(sharedPref.getBoolean("sweep2wake", getResources().getBoolean(R.bool.sweep2wake_default_enabled)));
        bln.setChecked(sharedPref.getBoolean("bln", getResources().getBoolean(R.bool.bln_default_enabled)));
        blnblink.setChecked(sharedPref.getBoolean("blnblink", getResources().getBoolean(R.bool.blnblink_default_enabled)));
        googledns.setChecked(sharedPref.getBoolean("googledns", getResources().getBoolean(R.bool.googledns_default_enabled)));
        clockfreeze.setChecked(sharedPref.getBoolean("clockfreeze", getResources().getBoolean(R.bool.clockfreeze_default_enabled)));
        incallaudio.setChecked(sharedPref.getBoolean("incallaudio",getResources().getBoolean(R.bool.incallaudio_default_enabled)));
        bttether.setChecked(sharedPref.getBoolean("bttether",getResources().getBoolean(R.bool.bttether_default_enabled)));
        /*h264softdec.setChecked(sharedPref.getBoolean("h264softdec",getResources().getBoolean(R.bool.h264softdec_default_enabled)));*/
        cpu2.setChecked(sharedPref.getBoolean("cpu2", true));
        LMKNKP.setChecked(sharedPref.getBoolean("LMKNKP", getResources().getBoolean(R.bool.LMKNKP_default_enabled)));
        charger_show_datetime.setChecked(FunctionsMain.getChargerShowDateTime());
        charger_no_suspend.setChecked(FunctionsMain.getChargerNoSuspend());
        autologcat.setChecked(sharedPref.getBoolean("autologcat",false));
        autokmsg.setChecked(sharedPref.getBoolean("autokmsg",false));
        autoril.setChecked(sharedPref.getBoolean("autoril",false));
	if(FunctionsMain.read_usb_reset() == 1)
	    otg.setChecked(true);
	else
	    otg.setChecked(false);
    }

    private View.OnClickListener switchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            ImageView thisSwitch = (ImageView)view;
            if(thisSwitch == whatis_venturi_variant){
                String varcode = FunctionsMain.getVenturiVariantCode();
                ShowDialog("USA Variant",getString(R.string.venturi_variant_desc) + "\n\nYour variant code is '" +
                        varcode + "'");
            }
            else if(thisSwitch == whatis_doubletap2wake){
                ShowDialog("DoubleTap2wake",getString(R.string.doubletap2wake_desc));
            }
            else if(thisSwitch == whatis_sweep2wake){
                ShowDialog("Sweep2wake",getString(R.string.sweep2wake_desc));
            }
            else if(thisSwitch == whatis_bln){
                ShowDialog("Backlight Notification",getString(R.string.bln_desc));
            }
            else if(thisSwitch == whatis_blnblink){
                ShowDialog("Blinking Backlight Notification",getString(R.string.blnblink_desc));
            }
            else if(thisSwitch == whatis_otg){
                ShowDialog("USB Host Mode",getString(R.string.otg_desc));
            }
            else if(thisSwitch == whatis_rdm_wlan_mac){
                ShowDialog("Random WLAN MAC:",getString(R.string.rdm_wlan_mac_desc));
            }
            else if(thisSwitch == whatis_googledns){
                ShowDialog("Google DNS",getString(R.string.googledns_desc));
            }
            else if(thisSwitch == whatis_clockfreeze){
                ShowDialog("Clock Freeze",getString(R.string.clockfreeze_desc));
            }
            else if(thisSwitch == whatis_incallaudio){
                ShowDialog("In-Call Audio",getString(R.string.incallaudio_desc));
            }

            else if(thisSwitch == whatis_bttether){
                ShowDialog("Bluetooth Tether",getString(R.string.bttether_desc));
            }
            else if(thisSwitch == whatis_h264softdec){
                ShowDialog("H.264 Software Decoder",getString(R.string.h264softdec_desc));
            }
            else if(thisSwitch == whatis_charger_show_datetime){
                ShowDialog("Date and Time in Charger",getString(R.string.charger_showdatetime_desc));
            }
            else if(thisSwitch == whatis_charger_no_suspend){
                ShowDialog("No Suspend in Charger",getString(R.string.charger_nosuspend_desc));
            }
            else if(thisSwitch == whatis_cpu2){
                ShowDialog("CPU2",getString(R.string.cpu2_desc));
            }
            else if(thisSwitch == whatis_LMKNKP){
                ShowDialog("Low Memory Killer",getString(R.string.LMKNKP_desc));
            }
            else if(thisSwitch == whatis_autologcat){
                ShowDialog("Auto Logcat",getString(R.string.autologcat_desc));
            }
            else if(thisSwitch == whatis_autokmsg){
                ShowDialog("Auto kmsg",getString(R.string.autokmsg_desc));
            }
            else if(thisSwitch == whatis_autorillog){
                ShowDialog("Auto kmsg",getString(R.string.autorillog_desc));
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            Switch thisSwitch = (Switch)compoundButton;
            SharedPreferences.Editor editor = sharedPref.edit();
            if(thisSwitch == venturi_variant){
                String varcode = FunctionsMain.getVenturiVariantCode();
                if(b) {
                    if(!varcode.equals("XAA") && !varcode.equals("XAC"))
                        FunctionsMain.setVenturiVariantCode("XAA");
                } else {
                    if(varcode.equals("XAA") || varcode.equals("XAC"))
                        FunctionsMain.setVenturiVariantCode("XAA");
                }
            }
            else if(thisSwitch == doubletap2wake){
                if(b != sharedPref.getBoolean("doubletap2wake", getResources().getBoolean(R.bool.doubletap2wake_default_enabled))) {
                    FunctionsMain.setDoubleTap2Wake(b);
                    editor.putBoolean("doubletap2wake", b);
                }

            }
            else if(thisSwitch == sweep2wake){
                if(b != sharedPref.getBoolean("sweep2wake", getResources().getBoolean(R.bool.doubletap2wake_default_enabled))) {
                    FunctionsMain.setSweep2Wake(b);
                    editor.putBoolean("sweep2wake", b);
                }

            }
            else if(thisSwitch == bln){
                if(b != sharedPref.getBoolean("bln", getResources().getBoolean(R.bool.bln_default_enabled))) {
                    FunctionsMain.setBLN(b);
                    editor.putBoolean("bln", b);
                }
                blnblink.setEnabled(b);

            }
            else if(thisSwitch == blnblink){
                if(b != sharedPref.getBoolean("blnblink", getResources().getBoolean(R.bool.blnblink_default_enabled))) {
                    FunctionsMain.setBLNBlink(b);
                    editor.putBoolean("blnblink", b);
                }

            }
            else if(thisSwitch == otg) { 
                try {
		    if(FunctionsMain.read_usb_reset() < 2)
                    	FunctionsMain.set_otg(b);
		    else {
			ShowDialog("Reboot Required","You'll need to reboot before using this again");
		    	otg.setChecked(false);
			otg.setEnabled(false);
		    }
                }
                catch(Exception e){e.printStackTrace();}
	    }
            else if(thisSwitch == rdm_wlan_mac) {

	    AsyncTask at = new AsyncTask() {
	        ProgressDialog wait;
                @Override
                protected Object doInBackground(Object[] objects) {
                    return FunctionsMain.set_random_mac(getApplicationContext());
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
		    wait.dismiss();
                    ShowDialog("New Wlan MAC",(String)o);
		    //rdm_wlan_mac.setChecked(false);
                }
	        @Override
	        protected void onPreExecute() {
		    super.onPreExecute();
		    wait = ShowIdProgDialog("Randomizing","Please Wait...");
		    wait.show();	
	        }
            };
	    if(b)	
	    	at.execute(new Object[]{});
            }
            else if(thisSwitch == googledns){
                if(b != sharedPref.getBoolean("googledns", getResources().getBoolean(R.bool.googledns_default_enabled))) {
                    FunctionsMain.setGoogleDNS(getApplicationContext(), b);
                    editor.putBoolean("googledns", b);
                }

            }
            else if(thisSwitch == clockfreeze){
                if(b != sharedPref.getBoolean("clockfreeze", getResources().getBoolean(R.bool.clockfreeze_default_enabled))) {
                    if (b)
                        FunctionsMain.startClockFreezeMonitorService(getApplicationContext());
                    else
                        ShowDialog("Clock Freeze Monitor", "Will NOT be started on the next reboot. " +
                                "Still running till then!");
                }
                editor.putBoolean("clockfreeze",b);

            }
            else if(thisSwitch == incallaudio){
                if(b != sharedPref.getBoolean("incallaudio",getResources().getBoolean(R.bool.incallaudio_default_enabled))) {
                    if (b)
                        FunctionsMain.startInCallAudioService(getApplicationContext());
                    else
                        ShowDialog("In-Call Audio", "Will NOT be started on the next reboot. " +
                                "Still running till then!");
                }
                editor.putBoolean("incallaudio",b);

            }
            else if(thisSwitch == bttether){
                editor.putBoolean("bttether", b);
            }
            else if(thisSwitch == h264softdec){
                editor.putBoolean("h264softdec", b);
                FunctionsMain.setH264SoftDec(b);
            }
            else if(thisSwitch == charger_show_datetime){
                FunctionsMain.setChargerShowDateTime(b);
            }
            else if(thisSwitch == charger_no_suspend){
                FunctionsMain.setChargerNoSuspend(b);
            }
            else if(thisSwitch == cpu2){
                editor.putBoolean("cpu2", b);
                FunctionsMain.SetCPU2(b);
            }
            else if(thisSwitch == LMKNKP){
                if(b) {
                    FunctionsMain.enableLMKNKP();
                    FunctionsMain.setLMKNKPWhitelist();
                }
                else
                    FunctionsMain.disableLMKNKP();

                editor.putBoolean("LMKNKP", b);
            }
            else if(thisSwitch == autologcat){
                if(b != sharedPref.getBoolean("autologcat",false))
                {
                    if(b)
                        ShowDialog("Auto logcat","Will be started on the next reboot.");
                    else
                        ShowDialog("Auto logcat","Will NOT be started on the next reboot. "+
                                "Still running till then");
                }
                editor.putBoolean("autologcat", b);
            }
            else if(thisSwitch == autokmsg){
                if(b != sharedPref.getBoolean("autokmsg",false))
                {
                    if(b)
                        ShowDialog("Auto kmsg","Will be started on the next reboot.");
                    else
                        ShowDialog("Auto kmsg","Will NOT be started on the next reboot. "+
                                "Still running till then");
                }
                editor.putBoolean("autokmsg", b);
            }
            else if(thisSwitch == autoril){
                if(b != sharedPref.getBoolean("autoril",false))
                {
                    if(b)
                        ShowDialog("Auto RIL log","Will be started on the next reboot.");
                    else
                        ShowDialog("Auto RIL log","Will NOT be started on the next reboot. "+
                                "Still running till then");
                }
                editor.putBoolean("autoril", b);
            }
            editor.apply();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    public AlertDialog ShowDialog(String title,String message)
    {
        return ShowDialog(title,message,true);
    }
    public AlertDialog ShowDialog(String title,String message, boolean okbtn)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
	if(okbtn)
            builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
	return dialog;
    }

    public ProgressDialog ShowIdProgDialog(String title,String message) {
	ProgressDialog pdialog = new ProgressDialog(this);
	pdialog.setTitle(title);
	pdialog.setMessage(message);
	pdialog.setIndeterminate(true);
	pdialog.setCancelable(false);
	pdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	return pdialog;
    }
}
