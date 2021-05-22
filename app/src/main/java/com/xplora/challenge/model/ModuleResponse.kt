package com.xplora.challenge.model

import com.google.gson.annotations.SerializedName

data class ModuleResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("errors")
	val errors: Any? = null
)

data class Title(

	@field:SerializedName("en")
	val en: String? = null
)

data class Images360(

	@field:SerializedName("es")
	val es: Any? = null,

	@field:SerializedName("de")
	val de: Any? = null,

	@field:SerializedName("en")
	val en: Any? = null,

	@field:SerializedName("pt")
	val pt: List<PtItem?>? = null
)

data class Description(

	@field:SerializedName("en")
	val en: String? = null
)

data class Image(

	@field:SerializedName("es")
	val es: Es? = null,

	@field:SerializedName("de")
	val de: De? = null,

	@field:SerializedName("en")
	val en: En? = null
)

data class Post(

	@field:SerializedName("api_token")
	val apiToken: String? = null
)

data class De(

	@field:SerializedName("url_thumb")
	val urlThumb: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class OutlineItem(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Documents(

	@field:SerializedName("es")
	val es: Any? = null,

	@field:SerializedName("de")
	val de: Any? = null,

	@field:SerializedName("en")
	val en: Any? = null
)

data class DeItem(

	@field:SerializedName("url")
	val url: String? = null
)

data class CoordinatesItem(

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("active")
	val active: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("radius")
	val radius: Int? = null,

	@field:SerializedName("modules")
	val modules: List<Int?>? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null
)

data class MarkersItem(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("modules")
	val modules: List<Any?>? = null
)

data class En(

	@field:SerializedName("url_thumb")
	val urlThumb: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class PtItem(

	@field:SerializedName("url")
	val url: String? = null
)

data class EnItem(

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("url_thumb")
	val urlThumb: String? = null
)

data class BeaconsItem(

	@field:SerializedName("reference")
	val reference: String? = null,

	@field:SerializedName("minor")
	val minor: Int? = null,

	@field:SerializedName("range")
	val range: String? = null,

	@field:SerializedName("description")
	val description: Description? = null,

	@field:SerializedName("active")
	val active: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: Title? = null,

	@field:SerializedName("battery")
	val battery: Int? = null,

	@field:SerializedName("local")
	val local: String? = null,

	@field:SerializedName("modules")
	val modules: List<Int?>? = null
)

data class Videos(

	@field:SerializedName("es")
	val es: Any? = null,

	@field:SerializedName("de")
	val de: Any? = null,

	@field:SerializedName("en")
	val en: Any? = null,

	@field:SerializedName("pt")
	val pt: List<PtItem?>? = null,

	@field:SerializedName("fr")
	val fr: List<FrItem?>? = null
)

data class Images(

	@field:SerializedName("de")
	val de: List<DeItem?>? = null,

	@field:SerializedName("pt")
	val pt: List<PtItem?>? = null,

	@field:SerializedName("en")
	val en: List<EnItem?>? = null,

	@field:SerializedName("fr")
	val fr: List<FrItem?>? = null,

	@field:SerializedName("es")
	val es: List<EsItem?>? = null
)

data class MediaItem(

	@field:SerializedName("file")
	val file: String? = null,

	@field:SerializedName("size")
	val size: Int? = null
)

data class Content(

	@field:SerializedName("es")
	val es: String? = null,

	@field:SerializedName("de")
	val de: String? = null,

	@field:SerializedName("pt")
	val pt: String? = null,

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("fr")
	val fr: String? = null
)

data class Es(

	@field:SerializedName("url_thumb")
	val urlThumb: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Data(

	@field:SerializedName("routes")
	val routes: List<Any?>? = null,

	@field:SerializedName("cards")
	val cards: List<Any?>? = null,

	@field:SerializedName("favourites")
	val favourites: List<Int?>? = null,

	@field:SerializedName("visited")
	val visited: List<Int?>? = null,

	@field:SerializedName("coordinates")
	val coordinates: List<CoordinatesItem?>? = null,

	@field:SerializedName("checked")
	val checked: List<Int?>? = null,

	@field:SerializedName("survey")
	val survey: List<Any?>? = null,

	@field:SerializedName("menus")
	val menus: List<Any?>? = null,

	@field:SerializedName("media")
	val media: List<MediaItem?>? = null,

	@field:SerializedName("markers")
	val markers: List<MarkersItem?>? = null,

	@field:SerializedName("modules")
	val modules: List<ModulesItem?>? = null,

	@field:SerializedName("beacons")
	val beacons: List<BeaconsItem?>? = null
)

data class Models3dItem(

	@field:SerializedName("start_time")
	val startTime: String? = null,

	@field:SerializedName("use_audio")
	val useAudio: String? = null,

	@field:SerializedName("end_time")
	val endTime: String? = null,

	@field:SerializedName("mesh_points")
	val meshPoints: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ModulesItem(

	@field:SerializedName("images360")
	val images360: Images360? = null,

	@field:SerializedName("image_new_version")
	val imageNewVersion: Any? = null,

	@field:SerializedName("featured")
	val featured: Boolean? = null,

	@field:SerializedName("cards")
	val cards: List<Any?>? = null,

	@field:SerializedName("documents")
	val documents: Documents? = null,

	@field:SerializedName("questions")
	val questions: List<Any?>? = null,

	@field:SerializedName("videos")
	val videos: Videos? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: Title? = null,

	@field:SerializedName("content")
	val content: Content? = null,

	@field:SerializedName("reference")
	val reference: String? = null,

	@field:SerializedName("routes")
	val routes: List<Any?>? = null,

	@field:SerializedName("outline")
	val outline: List<OutlineItem?>? = null,

	@field:SerializedName("checkin")
	val checkin: Boolean? = null,

	@field:SerializedName("related")
	val related: List<Any?>? = null,

	@field:SerializedName("children")
	val children: List<Any?>? = null,

	@field:SerializedName("has_hammer")
	val hasHammer: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("coordinates")
	val coordinates: List<Int?>? = null,

	@field:SerializedName("playlists")
	val playlists: List<Any?>? = null,

	@field:SerializedName("image_title")
	val imageTitle: ImageTitle? = null,

	@field:SerializedName("sort")
	val sort: Any? = null,

	@field:SerializedName("beacons")
	val beacons: List<Int?>? = null,

	@field:SerializedName("tags")
	val tags: List<Any?>? = null,

	@field:SerializedName("models_3d")
	val models3d: List<Models3dItem?>? = null,

	@field:SerializedName("parent_id")
	val parentId: Int? = null,

	@field:SerializedName("image_old_version")
	val imageOldVersion: Any? = null,

	@field:SerializedName("audios")
	val audios: Audios? = null,

	@field:SerializedName("timeline")
	val timeline: List<Any?>? = null,

	@field:SerializedName("detail")
	val detail: String? = null,

	@field:SerializedName("markers")
	val markers: List<Any?>? = null,

	@field:SerializedName("category")
	val category: Any? = null,

	@field:SerializedName("ra_range")
	val raRange: Boolean? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Audios(

	@field:SerializedName("es")
	val es: List<EsItem?>? = null,

	@field:SerializedName("de")
	val de: List<DeItem?>? = null,

	@field:SerializedName("pt")
	val pt: List<PtItem?>? = null,

	@field:SerializedName("en")
	val en: List<EnItem?>? = null,

	@field:SerializedName("fr")
	val fr: List<FrItem?>? = null
)

data class FrItem(

	@field:SerializedName("url")
	val url: String? = null
)

data class ImageTitle(

	@field:SerializedName("es")
	val es: Any? = null,

	@field:SerializedName("de")
	val de: Any? = null,

	@field:SerializedName("en")
	val en: Any? = null
)

data class EsItem(

	@field:SerializedName("url")
	val url: String? = null
)
