/*
 * Copyright (c) 2017. Sipke Vriend
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   * Neither the name of canstr nor the names of its contributors may be used
 *     to endorse or promote products derived from this software without
 *     specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package canstr.android.ui.bargauge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class GaugeContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<GaugeItem> ITEMS = new ArrayList<GaugeItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, GaugeItem> ITEM_MAP = new HashMap<String, GaugeItem>();

    private static final int COUNT = 5;

    public static void addItem(String id, float value, float max) {
        GaugeItem item = new GaugeItem(id, value, max);
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void updateItem(String id, float value) {
        GaugeItem item = ITEM_MAP.get(id);
        if (item != null) {
            item.content = value;
        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class GaugeItem {
        public final String id;
        public float content;
        public float max;

        public GaugeItem() {
            this.id = "";
            this.content = 0;
            this.max = 0;
        }

        public GaugeItem(String id, float content, float max) {
            this.id = id;
            this.content = content;
            this.max = max;
        }

        @Override
        public String toString() {
            return "blah";
        }
    }
}
