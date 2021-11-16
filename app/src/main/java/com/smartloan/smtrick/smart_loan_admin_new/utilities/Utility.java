package com.smartloan.smtrick.smart_loan_admin_new.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.FOUR_DIGIT_LIMIT;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.TWO_DIGIT_LIMIT;

public class Utility {
    public static Snackbar snackbar;
    public static void showMessage(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongMessage(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }

    public static String generateAgentId(String str) {
        String nameSubStr = null, yearSubStr, monthSubStr, randomNum;
        if (str != null) {
            if (str.length() >= 3) {
                nameSubStr = str.substring(0, 3);
            } else
                nameSubStr = str;
        }
        yearSubStr = Integer.toString(Constant.YEAR).substring(2, 4);
        monthSubStr = String.format(TWO_DIGIT_LIMIT, Constant.MONTH + 1);
        randomNum = String.format(FOUR_DIGIT_LIMIT, (1 + new Random().nextInt(1000)));
        return nameSubStr + yearSubStr + monthSubStr + randomNum;
    }

    public static boolean isValidEmail(String email) {
        try {
            String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } catch (Exception e) {
            ExceptionUtil.logException(e);
        }
        return false;
    }

    public static boolean isEmptyOrNull(String value) {
        if (value == null || value.isEmpty() || value.matches("")) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Long value) {
        if (value == null) {
            return true;
        }
        return false;
    }

    public static boolean isValidUserName(String userName) {
        if (userName.length() <= 50) {
            return true;
        }
        return false;
    }

    public static boolean isValidAmount(String inputAmount, int minimanLimit) {
        if (!isEmptyOrNull(inputAmount)) {
            double amount = Double.valueOf(inputAmount);
            if (amount >= minimanLimit)
                return true;
            else
                return false;
        }
        return false;
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{8,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidAadhaar(String aadhaaar) {
        if (aadhaaar != null && aadhaaar.length() == 12) {
            return true;
        }
        return false;
    }

    public static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.length() <= 20) {
            return true;
        }
        return false;
    }

    public static boolean isValidIfsc(String ifsc) {
        if (ifsc != null && ifsc.length() == 11) {
            String ifscPattern = "^[A-Z|a-z]{4}[0][0-9]{6}$";
            Pattern pattern = Pattern.compile(ifscPattern);
            Matcher matcher = pattern.matcher(ifsc);
            return matcher.matches();
        }
        return false;
    }

    public static boolean isValidVpa(String vpa) {
        if (vpa != null && vpa.length() == 11) {
            String vpaPattern = "^[A-Z|a-z]{3}[@][A-Z|a-z]{3}$";
            Pattern pattern = Pattern.compile(vpaPattern);
            Matcher matcher = pattern.matcher(vpa);
            return matcher.matches();
        }
        return false;
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        if (mobileNumber != null && mobileNumber.length() == 10) {
            /*Pattern pattern;
            Matcher matcher;
            final String mobileNumberPattern = "^[1-9][0-9]{9}$";
            pattern = Pattern.compile(mobileNumberPattern);
            matcher = pattern.matcher(mobileNumber);
            return matcher.matches();*/
            return true;
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            return false;
        } else
            return true;
    }

    public static void showSnackBar(Context context,View coordinatorLayout, String string) {
        snackbar = Snackbar.make(coordinatorLayout, string, Snackbar.LENGTH_INDEFINITE).
                setAction(R.string.dismiss, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
        View snackbarView = snackbar.getView();
        TextView textView = (TextView) snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setMaxLines(8);//this is your max line as your want
        snackbarView.setBackgroundColor(ContextCompat.getColor(context, R.color.hederbackground));
        textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        snackbar.show();
    }

    public static void showTimedSnackBar(Context context,View coordinatorLayout, String string) {
        snackbar = Snackbar.make(coordinatorLayout, string, Snackbar.LENGTH_LONG).
                setAction(R.string.dismiss, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
        View snackbarView = snackbar.getView();
        TextView textView = (TextView) snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        snackbarView.setBackgroundColor(ContextCompat.getColor(context, R.color.hederbackground));
        textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        textView.setMaxLines(8);//this is your max line as your want
        snackbar.show();
    }

    public static String convertMilliSecondsToFormatedDate(long dateInMilliseconds, String dateFormat) {
        try {
            return android.text.format.DateFormat.format(dateFormat, dateInMilliseconds).toString();
        } catch (Exception e) {
            ExceptionUtil.logException(e);
            return "";
        }
    }
    public static long convertFormatedDateToMilliSeconds(String string_date, String dateFormat) {
        try {
            if (string_date == null || string_date.equalsIgnoreCase(""))
                return 0;
            SimpleDateFormat f = new SimpleDateFormat(dateFormat);
            Date d = f.parse(string_date);
            return d.getTime();
        } catch (Exception e) {
            ExceptionUtil.logException(e);
            return 0;
        }
    }

    public static Bitmap blur(Context context, Bitmap image) {
        final float BITMAP_SCALE = 0.4f;
        final float BLUR_RADIUS = 3f;
        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);
        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);
        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }

    public static InputStream returnInputStreamFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();
        ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
        return bs;
    }

    public static final int[] MATERIAL_COLORS = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")
    };

    public static int rgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }
}
