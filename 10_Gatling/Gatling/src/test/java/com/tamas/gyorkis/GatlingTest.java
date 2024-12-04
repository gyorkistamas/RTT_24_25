package com.tamas.gyorkis;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class GatlingTest extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://todolist.james.am")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("hu-HU,hu;q=0.8,en-US;q=0.5,en;q=0.3")
    .doNotTrackHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:133.0) Gecko/20100101 Firefox/133.0");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    Map.entry("Accept-Encoding", "gzip, deflate"),
    Map.entry("Priority", "u=0, i"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:53 GMT"),
    Map.entry("If-None-Match", "W/\"7ee4960c3fdfa8a88b3b540e19fcf7ff\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Accept", "text/css,*/*;q=0.1"),
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:50 GMT"),
    Map.entry("If-None-Match", "W/\"f29c4945c1d5c1750aaa1b0a47b372e2\""),
    Map.entry("Priority", "u=2"),
    Map.entry("Sec-Fetch-Dest", "style"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Accept", "text/css,*/*;q=0.1"),
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:50 GMT"),
    Map.entry("If-None-Match", "W/\"fdb11056de60b06dc72e652dd8cb0027\""),
    Map.entry("Priority", "u=2"),
    Map.entry("Sec-Fetch-Dest", "style"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:51 GMT"),
    Map.entry("If-None-Match", "W/\"f9e3e662c0698e830be89599d7620e0f\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_7 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:42 GMT"),
    Map.entry("If-None-Match", "W/\"dc3667ebb99620f3cc241fc77973a293\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_8 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:42 GMT"),
    Map.entry("If-None-Match", "W/\"a37e919afa2bd668e9e56cf28089e5f5\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_9 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:43 GMT"),
    Map.entry("If-None-Match", "W/\"65d2e69751ed9cc17cdaf28b6b6e2fe6\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_10 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:41 GMT"),
    Map.entry("If-None-Match", "W/\"4319742716c9ae5e1d541837bf1749d2\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_11 = Map.ofEntries(
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_12 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Sun, 22 Dec 2019 13:05:42 GMT"),
    Map.entry("If-None-Match", "W/\"6dbbcc29e0933dc8e3590def352f7291\""),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("Accept", "application/json, text/plain, */*"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );

  private String uri1 = "todolist.james.am";

  private ScenarioBuilder scn = scenario("GatlingTest")
    .exec(
      http("request_0")
        .get("/")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("https://" + uri1 + "/node_modules/angular-route/angular-route.js")
            .headers(headers_1),
          http("request_2")
            .get("https://" + uri1 + "/node_modules/angular/angular.js")
            .headers(headers_2),
          http("request_3")
            .get("https://" + uri1 + "/node_modules/todomvc-app-css/index.css")
            .headers(headers_3),
          http("request_4")
            .get("https://" + uri1 + "/node_modules/todomvc-common/base.css")
            .headers(headers_4),
          http("request_5")
            .get("https://" + uri1 + "/node_modules/angular-resource/angular-resource.js")
            .headers(headers_5),
          http("request_6")
            .get("https://" + uri1 + "/node_modules/todomvc-common/base.js")
            .headers(headers_1),
          http("request_7")
            .get("https://" + uri1 + "/js/app.js")
            .headers(headers_7),
          http("request_8")
            .get("https://" + uri1 + "/js/services/todoStorage.js")
            .headers(headers_8),
          http("request_9")
            .get("https://" + uri1 + "/js/controllers/todoCtrl.js")
            .headers(headers_9),
          http("request_10")
            .get("https://" + uri1 + "/js/directives/todoEscape.js")
            .headers(headers_10),
          http("request_11")
            .get("https://" + uri1 + "/learn.json")
            .headers(headers_11)
            .check(status().is(404)),
          http("request_12")
            .get("https://" + uri1 + "/js/directives/todoFocus.js")
            .headers(headers_12),
          http("request_13")
            .get("https://" + uri1 + "/api")
            .headers(headers_13)
            .check(status().is(404))
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(10))).protocols(httpProtocol);
  }
}
