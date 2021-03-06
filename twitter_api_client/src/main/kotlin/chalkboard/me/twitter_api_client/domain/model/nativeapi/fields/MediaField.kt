package chalkboard.me.twitter_api_client.domain.model.nativeapi.fields

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.EnumQueryFields

/**
 * レスポンスに追加するメディア情報の拡張パラメータ
 * expansions=attachments.media_keysクエリパラメータが必須
 */
enum class MediaField(override val query: String) : EnumQueryFields {
    DURATION_MS("duration_ms"), // タイプがビデオの場合に利用可能です。動画の持続時間をミリ秒単位で指定します
    HEIGHT("height"), // このコンテンツの高さをピクセル単位で指定します
    MEDIA_KEY("media_key"), // 拡張メディアコンテンツの一意の識別子
    PREVIEW_IMAGE_URL("preview_image_url"), // このコンテンツの静的なプレースホルダのプレビューへの URL
    TYPE("type"), // コンテンツの種類（animated_gif、写真、動画）
    URL("url"),
    WIDTH("width"), // コンテンツの幅
    PUBLIC_METRICS("public_metrics"),
    NON_PUBLIC_METRICS("non_public_metrics"),
    ORGANIC_METRICS("organic_metrics"),
    PROMOTED_METRICS("promoted_metrics")
}
