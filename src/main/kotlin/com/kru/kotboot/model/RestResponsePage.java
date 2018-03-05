/**
 * 
 */
package com.kru.kotboot.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * @author <a href="mailto:krunalsabnis@gmail.com">Krunal Sabnis</a>
 *
 */

public class RestResponsePage<T> extends PageImpl<T>{

  private static final long serialVersionUID = 3248189030448292002L;

  public RestResponsePage(List<T> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }

  public RestResponsePage(List<T> content) {
    super(content);
  }

  /* PageImpl does not have an empty constructor and this was 
   * causing an issue for RestTemplate to cast the Rest API response
   * back to Page.
   * 
   * reference : https://stackoverflow.com/questions/34647303/spring-resttemplate-with-paginated-api
   */
  public RestResponsePage() {
    super(new ArrayList<T>());
  }

} 