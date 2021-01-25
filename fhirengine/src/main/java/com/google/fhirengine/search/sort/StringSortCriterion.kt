/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.fhirengine.search.sort

import ca.uhn.fhir.rest.gclient.StringClientParam
import com.google.fhirengine.search.filter.FilterCriterion

/**
 * [FilterCriterion] on a string value.
 *
 * For example:
 * * name that matches 'Tom'
 * * address that includes 'London'
 */
data class StringSortCriterion constructor(
    val stringParam: StringClientParam,
    override val ascending: Boolean
) : SortCriterion {
    override val table: String = "StringIndexEntity"
    override val param = stringParam.paramName
}

fun stringSort(param: StringClientParam, ascending: Boolean) =
    StringSortCriterion(param, ascending)
