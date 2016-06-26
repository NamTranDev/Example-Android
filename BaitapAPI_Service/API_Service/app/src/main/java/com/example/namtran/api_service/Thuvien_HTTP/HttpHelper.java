package com.example.namtran.api_service.Thuvien_HTTP;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.namtran.api_service.R;


import org.json.JSONObject;


public final class HttpHelper {

    public static final int TIMEOUT = 10000;
    public static final int RETRY_TIMES = 0;
//    public static final String ERR_MSG_EXCEPTION;
//    public static final String ERR_MSG_TIMEOUT;

    private static HttpHelper mInstance;
    private RequestQueue mRequestQueue;
    private final Context context;

    private HttpHelper(Context context) {
        // TODO: init component
        mRequestQueue = Volley.newRequestQueue(context);
        this.context = context;
//        ERROR_CODE = context.getString(R.string.err_msg_with_code);
    }

    public static synchronized HttpHelper getInstance(Context context) {
        if(null == mInstance) {
            mInstance = new HttpHelper(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    /**
     * add request message to queue
     * @param request
     * @param tag: use in case cancellable request
     * @param <T>
     */
    private <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(tag);
        mInstance.getRequestQueue().add(request);
    }

    /**
     * add request message to queue
     * @param request
     * @param <T>
     */
    private <T> void addToRequestQueue(Request<T> request) {
        mInstance.getRequestQueue().add(request);
    }

    /**
     * cancel specific requests with given tag, if null: throw exception
     * @param tag
     */
    public void cancelRequest(String tag) {
        if(null == tag)
            throw new IllegalArgumentException("did you forgot set TAG for volley request?");
        mRequestQueue.cancelAll(tag);
    }

    public static interface Method {
        int POST = Request.Method.POST;
        int GET = Request.Method.GET;
    }

//    public int methodPost() {
//        return Request.Method.POST;
//    }
//
//    public int methodGet() { return Request.Method.GET; }

    /**
     * build-in helper function
     * request data: JSONObject
     * response data: JSONObject
//     * @param method POST or GET request
     * @param url
     * @param jsonRequest
     * @param responseHandler
     * @param errorHandler
     * @param tag
     * @param timeout: Specifies Socket Timeout in millis per every retry attempt.
     * @param retryTimes: Number of times retry is attempted.
//     * @param elapseTime: A multiplier which is used to determine exponential time set to socket for every retry attempt.
     */
    public void makeJsonRequest(int method, String url, Object jsonRequest, final ResponseHandler responseHandler, final ResponseErrorHandler errorHandler, String tag, int timeout, int retryTimes) {
        MJsonObjRequest jsonObjectRequest = new MJsonObjRequest(
                method,
                url,
                (JSONObject) jsonRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
//                        Log.d("vinh.http" + jsonObject.toString());
                        // TODO: handle response from server
                        responseHandler.handleJsonResponse(jsonObject);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
//                        Log.e("volley.debugging.error", volleyError.getMessage());
                        String msg = null;
                        /** network response == null */
                        if(volleyError.getClass().equals(NoConnectionError.class)) {
                            msg = context.getString(R.string.http_err_no_connection);
                        /** network content == null */
                        } else if(volleyError.getClass().equals(NetworkError.class)) {
                            msg = context.getString(R.string.http_err_network_error);
                        /** connection || response timeout */
                        } else if(volleyError.getClass().equals(TimeoutError.class)) {
                                    msg = context.getString(R.string.http_err_connection_timeout);
                        /** server error (error code: 5xx) */
                        } else if(volleyError.getClass().equals(ServerError.class)) {
                            msg = context.getString(R.string.http_err_server_error)
                                    + volleyError.networkResponse.statusCode;
                        /** response content cannot convert to Json */
                        } else if(volleyError.getClass().equals(ParseError.class)) {
                            msg = context.getString(R.string.http_err_resp_content_error);
                        } else { /** shouldn't reach to this code */
                            msg = "Lỗi, mã lỗi: 000";
                        }
                        errorHandler.handleError(volleyError, msg);
                    }
                }
        );
        jsonObjectRequest.setShouldCache(false);
        // references
        // http://stackoverflow.com/questions/17094718/android-volley-timeout
        if(timeout > 0) {
//            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(timeout, retryTimes, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(timeout, retryTimes, 0));
        }
        if(null == tag) {
            this.addToRequestQueue(jsonObjectRequest);
        } else {
            this.addToRequestQueue(jsonObjectRequest, tag);
        }
    }

    public interface ResponseHandler {
        void handleJsonResponse(JSONObject jsonObject);
    }

    public interface ResponseErrorHandler {
        void handleError(VolleyError error, String msg);
    }
}
