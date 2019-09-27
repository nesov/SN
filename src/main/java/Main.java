//package app;
//
//import okhttp3.*;
//import okio.BufferedSink;
//
//import javax.annotation.Nullable;
//import java.io.IOException;
//
//public class Main {
//
//
//
//    public static void main(String[] args) {
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody requestBody = new RequestBody().contentTyp {
//            @Nullable
//            @Override
//            public MediaType contentType() {
//                return null;
//            }
//
//            @Override
//            public void writeTo(BufferedSink bufferedSink) throws IOException {
//
//            }
//        }
//
//        Request request = new Request.Builder()
//                .url("https://synergy.net/api/view/explore").post()
//                .build();
//
//        try (Response response = client.newCall(request).execute().networkResponse()) {
//            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//            Headers responseHeaders = response.headers();
//            for (int i = 0; i < responseHeaders.size(); i++) {
//                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//            }
//
//            System.out.println(response.body().string());
//
//
//            } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
