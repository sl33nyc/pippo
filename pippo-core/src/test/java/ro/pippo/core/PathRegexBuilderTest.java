/*
 * Copyright (C) 2015 the original author or authors.
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
package ro.pippo.core;

import org.junit.Test;
import ro.pippo.core.util.PathRegexBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @author Decebal Suiu
 */
public class PathRegexBuilderTest {

    @Test
    public void testBuild() throws Exception {
        String test = "/admin";

        String regex = new PathRegexBuilder()
            .includes(
                "/admin"
            )
            .excludes(
                "/admin/login",
                "/webjars",
                "/public"
            )
            .build();

        Matcher matcher = Pattern.compile(regex).matcher(test);
        assertTrue(matcher.matches());
    }

}
