/* Copyright 2013 Alex Burka

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
package org.wwolf.s4coveroff;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;


public class AdminReceiver extends DeviceAdminReceiver {
	
	@Override
	public void onEnabled(Context context, Intent intent) {
		Functions.Events.device_admin_status(context, true);
	}
	
	@Override
	public void onDisabled(Context context, Intent intent) {
		Functions.Events.device_admin_status(context, false);
	}

}
