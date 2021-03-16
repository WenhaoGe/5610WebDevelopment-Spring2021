package com.example.wbdvspring2021wenhaoserverjava.services;

import com.example.wbdvspring2021wenhaoserverjava.models.Widget;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

  private List<Widget> widgets = new ArrayList<>();
  {
    Widget w1 = new Widget(123l, "HEADING", 1, "Widgets for Topic ABC123", "ABC123");
    Widget w2 = new Widget(234l, "PARAGRAPH", 1, "Lorem Ipsum", "ABC123");
    Widget w3 = new Widget(345l, "HEADING", 2, "Widgets for Topic ABC234", "ABC234");
    Widget w4 = new Widget(456l, "PARAGRAPH", 1, "Lorem Ipsum", "ABC234");
    Widget w5 = new Widget(567l, "PARAGRAPH", 1, "Lorem Ipsum", "ABC234");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
  }

  public Widget createWidget(String tid, Widget widget) {
    Long id = (new Date()).getTime();
    widget.setTopicId(tid);
    widget.setId(id);
    widgets.add(widget);
    return widget;

  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> ws = new ArrayList<>();
    for (int i = 0; i < widgets.size(); i++) {
      if (widgets.get(i).getTopicId().equals(tid)) {
        ws.add(widgets.get(i));
      }
    }
    return ws;
  }

  public int updateWidget(String wid, Widget widget) {

    if (widget == null) {
      return 0;
    }
    Long id = Long.parseLong(wid);
    widget.setId(id);
    return 1;
  }

  public int deleteWidget(String wid) {

    int removed = 0;
    for (int i = 0; i < widgets.size(); i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(wid)) {
        widgets.remove(i);
        removed = 1;
      }
    }
    return removed;
  }

  public Widget findWidgetById(String wid) {

    Long id = Long.parseLong(wid);
    for (int i = 0; i < widgets.size(); i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(id)) {
        return w;
      }
    }
    return null;
  }

}
