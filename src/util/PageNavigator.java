/*
 * Copyright (c) 2022 by Imran R.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package util;

import javafx.scene.Scene;
import models.Page;

import java.util.HashMap;


public class PageNavigator {

    private static final HashMap<String, Page> pageMap = new HashMap<>() ;
    private static Scene mainScene = null ;

    public static void setMainScene(Scene scene) {
        mainScene = scene ;
    }

    public static void add(String pageName, Page page) {
        pageMap.put(pageName, page) ;
    }

    public static void remove(String pageName) {
        pageMap.remove(pageName) ;
    }

    public static void activatePage(String pageName) {
        Page page = getPage(pageName) ;

        mainScene.setRoot(page.getPane()) ;
        mainScene.getStylesheets().clear() ;
        mainScene.getStylesheets().add(page.getPathToStylesheet()) ;
    }

    public static Page getPage(String pageName) {
        return pageMap.get(pageName) ;
    }
}
