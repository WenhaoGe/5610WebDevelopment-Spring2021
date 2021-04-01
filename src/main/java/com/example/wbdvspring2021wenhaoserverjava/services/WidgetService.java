package com.example.wbdvspring2021wenhaoserverjava.services;

import com.example.wbdvspring2021wenhaoserverjava.models.Widget;
import com.example.wbdvspring2021wenhaoserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  public Widget createWidgetForTopic(Widget widget) {

    return repository.save(widget);
  }

  public List<Widget> findAllWidgets() {

    return repository.findAllWidgets();

//    return (List<Widget>) repository.findAll();

//    return widgets;
  }

  public List<Widget> findWidgetsForTopic(String tid) {

    return repository.findWidgetForTopic(tid);
//    List<Widget> ws = new ArrayList<>();
//    for (int i = 0; i < widgets.size(); i++) {
//      if (widgets.get(i).getTopicId().equals(tid)) {
//        ws.add(widgets.get(i));
//      }
//    }
//    return ws;
  }

  public int updateWidget(Long wid, Widget widget) {

    Widget originalWidget = findWidgetById(wid);
    originalWidget.setText(widget.getText());
    originalWidget.setSrc(widget.getSrc());
    originalWidget.setWidth(widget.getWidth());
    originalWidget.setHeight(widget.getHeight());
    // width height

    repository.save(originalWidget);
    return 1;

//    if (widget == null) {
//      return 0;
//    }
//    Long id = Long.parseLong(wid);
//    widget.setId(id);
//    return 1;
  }

  public int deleteWidget(Long wid) {

    repository.deleteById(wid);
    return 1;
  }

  public Widget findWidgetById(Long wid) {

    return repository.findWidgetById(wid);

//    Long id = Long.parseLong(wid);
//    for (int i = 0; i < widgets.size(); i++) {
//      Widget w = widgets.get(i);
//      if (w.getId().equals(id)) {
//        return w;
//      }
//    }
//    return null;
  }

}
