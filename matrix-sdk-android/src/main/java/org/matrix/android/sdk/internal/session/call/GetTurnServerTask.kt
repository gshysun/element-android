/*
 * Copyright 2020 The Matrix.org Foundation C.I.C.
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

package org.matrix.android.sdk.internal.session.call

import org.matrix.android.sdk.api.session.call.TurnServerResponse
import org.matrix.android.sdk.internal.network.executeRequest
import org.matrix.android.sdk.internal.task.Task
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

internal abstract class GetTurnServerTask : Task<GetTurnServerTask.Params, TurnServerResponse> {
    object Params
}

internal class DefaultGetTurnServerTask @Inject constructor(private val voipAPI: VoipApi,
                                                            private val eventBus: EventBus) : GetTurnServerTask() {

    override suspend fun execute(params: Params): TurnServerResponse {
        return executeRequest(eventBus) {
            apiCall = voipAPI.getTurnServer()
        }
    }
}
