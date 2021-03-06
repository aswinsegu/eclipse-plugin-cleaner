/*******************************************************************************
 * Copyright 2014 Chocolate Jar, Andrej Zachar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 *******************************************************************************/
package eu.chocolatejar.eclipse.plugin.cleaner.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/**
 * Filters only file(s) within the dropins folder.
 */
public class DropinsFilter implements FileFilter {

    /**
     * Name for the Eclipse dropins folder
     */
    public static final String DROPINS = "dropins";

    private static final String SLASH = "\\" + File.separator;

    private static final Pattern DROPINS_FOLDER_PATTERN = Pattern.compile("(" + SLASH + "?(" + DROPINS + SLASH
            + "){1})+");

    @Override
    public boolean accept(File file) {
        if (file == null) {
            return false;
        }
        return DROPINS_FOLDER_PATTERN.matcher(file.getAbsolutePath()).find();
    }

}
