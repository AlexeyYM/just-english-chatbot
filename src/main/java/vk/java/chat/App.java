package vk.java.chat;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.GroupAuthResponse;

public class App {
  private static final int CLIENT_ID = 7174969;
  private static final String CLIENT_SECRET = "ezXr4XZXdti0s6CqzM8S";
  private static final String REDIRECT_URI = "";
  private static final String CODE = "";
  private static final int GROUP_ID = 184113677;


  public static void main(String[] args) {
    TransportClient transportClient = HttpTransportClient.getInstance();
    VkApiClient vk = new VkApiClient(transportClient);
    GroupAuthResponse authResponse = null;
    try {
      authResponse = vk.oauth()
          .groupAuthorizationCodeFlow(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, CODE)
          .execute();
    } catch (ApiException e) {
      e.printStackTrace();
    } catch (ClientException e) {
      e.printStackTrace();
    }

    GroupActor actor = new GroupActor(GROUP_ID, authResponse.getAccessTokens().get(GROUP_ID));
  }
}
