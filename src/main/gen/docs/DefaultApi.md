# DefaultApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**collectivitiesIdAssignPut**](DefaultApi.md#collectivitiesIdAssignPut) | **PUT** /collectivities/{id}/assign | Attribution du numéro et du nom unique à une collectivité |
| [**collectivitiesPost**](DefaultApi.md#collectivitiesPost) | **POST** /collectivities | Créer une collectivité |
| [**membersPost**](DefaultApi.md#membersPost) | **POST** /members | Créer un membre avec sponsors |


<a id="collectivitiesIdAssignPut"></a>
# **collectivitiesIdAssignPut**
> Collectivity collectivitiesIdAssignPut(id, collectivityAssignRequest)

Attribution du numéro et du nom unique à une collectivité

Fonction J - assignation du numéro et du nom unique

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    CollectivityAssignRequest collectivityAssignRequest = new CollectivityAssignRequest(); // CollectivityAssignRequest | 
    try {
      Collectivity result = apiInstance.collectivitiesIdAssignPut(id, collectivityAssignRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdAssignPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |
| **collectivityAssignRequest** | [**CollectivityAssignRequest**](CollectivityAssignRequest.md)|  | |

### Return type

[**Collectivity**](Collectivity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Collectivité mise à jour |  -  |

<a id="collectivitiesPost"></a>
# **collectivitiesPost**
> Collectivity collectivitiesPost(collectivity)

Créer une collectivité

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Collectivity collectivity = new Collectivity(); // Collectivity | 
    try {
      Collectivity result = apiInstance.collectivitiesPost(collectivity);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **collectivity** | [**Collectivity**](Collectivity.md)|  | |

### Return type

[**Collectivity**](Collectivity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Collectivité créée |  -  |

<a id="membersPost"></a>
# **membersPost**
> Member membersPost(memberRequest)

Créer un membre avec sponsors

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    MemberRequest memberRequest = new MemberRequest(); // MemberRequest | 
    try {
      Member result = apiInstance.membersPost(memberRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#membersPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **memberRequest** | [**MemberRequest**](MemberRequest.md)|  | |

### Return type

[**Member**](Member.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Membre créé |  -  |

