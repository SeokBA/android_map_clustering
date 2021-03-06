/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.naver.hackday2020.mapclustering.clustering.algo.geometry

/**
 * Represents an area in the cartesian plane.
 */
class Bounds(
    val minX: Double,
    val maxX: Double,
    val minY: Double,
    val maxY: Double
) {

    val midX: Double = (minX + maxX) / 2
    val midY: Double = (minY + maxY) / 2

    fun contains(x: Double, y: Double): Boolean {
        return x in minX..maxX && y in minY..maxY
    }

    operator fun contains(point: Point): Boolean {
        return contains(point.x, point.y)
    }

    fun intersects(minX: Double, maxX: Double, minY: Double, maxY: Double): Boolean {
        return minX < this.maxX && this.minX < maxX && minY < this.maxY && this.minY < maxY
    }

    fun intersects(bounds: Bounds): Boolean {
        return intersects(bounds.minX, bounds.maxX, bounds.minY, bounds.maxY)
    }

    operator fun contains(bounds: Bounds): Boolean {
        return bounds.minX >= minX && bounds.maxX <= maxX && bounds.minY >= minY && bounds.maxY <= maxY
    }
}