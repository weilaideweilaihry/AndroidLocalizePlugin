/*
 * Copyright 2021 Airsaid. https://github.com/airsaid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.airsaid.localization.translate.impl.google;

import com.airsaid.localization.translate.AbstractTranslator;
import com.airsaid.localization.translate.lang.Lang;
import com.airsaid.localization.translate.lang.Languages;
import icons.PluginIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author airsaid
 */
public abstract class AbsGoogleTranslator extends AbstractTranslator {

  protected List<Lang> supportedLanguages;

  @Override
  public @NotNull Icon getIcon() {
    return PluginIcons.GOOGLE_ICON;
  }

  @Override
  @NotNull
  public List<Lang> getSupportedLanguages() {
    if (supportedLanguages == null) {
      //List<Lang> languages = Languages.getLanguages();
      List<Lang> languages = new ArrayList<>();
      languages.add(Languages.CHINESE_SIMPLIFIED);
      languages.add(Languages.CHINESE_TRADITIONAL);
      languages.add(Languages.JAPANESE);
      languages.add(Languages.KOREAN);

      languages.add(Languages.HINDI);
      languages.add(Languages.INDONESIAN);
      languages.add(Languages.PORTUGUESE);
      languages.add(Languages.RUSSIAN);


      supportedLanguages = new ArrayList<>();

      for (int i = 0; i < languages.size(); i++) {
        Lang lang = languages.get(i);
        if (lang.equals(Languages.CHINESE_SIMPLIFIED)) {
          lang = lang.setTranslationCode("zh-CN");
        } else if (lang.equals(Languages.CHINESE_TRADITIONAL)) {
          lang = lang.setTranslationCode("zh-TW");
        } else if (lang.equals(Languages.FILIPINO)) {
          lang = lang.setTranslationCode("tl");
        } else if (lang.equals(Languages.INDONESIAN)) {
          lang = lang.setTranslationCode("id-ID");
        } else if (lang.equals(Languages.HINDI)) {
          lang = lang.setTranslationCode("hi-IN");
        } else if (lang.equals(Languages.PORTUGUESE)) {
          lang = lang.setTranslationCode("pt-BR");
        }else if (lang.equals(Languages.JAVANESE)) {
          lang = lang.setTranslationCode("jw");
        }
        supportedLanguages.add(lang);
      }
    }
    return supportedLanguages;
  }
}
