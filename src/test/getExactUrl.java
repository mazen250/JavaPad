package test;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public static String getExactUrl(String url) {
    Map<String, String> queryParams = getQueryParamsMap(url);
    return queryParams.getOrDefault("r", url);
}

public static Map<String, String> getQueryParamsMap(String url) {
    Map<String, String> queryParamsMap = new HashMap<>();
    try {
        URIBuilder uriBuilder = new URIBuilder(url);
        List<NameValuePair> queryParams = uriBuilder.getQueryParams();
        queryParamsMap = queryParams.stream().collect(Collectors.toMap(NameValuePair::getName, NameValuePair::getValue));
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
    return queryParamsMap;
}