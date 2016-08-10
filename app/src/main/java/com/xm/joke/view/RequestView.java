package com.xm.joke.view;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */

public interface RequestView<T> {

    void onRequestFinished();

    void onRequestSuccess(List<T> list);

}
