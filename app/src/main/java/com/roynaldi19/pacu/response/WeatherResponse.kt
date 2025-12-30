import com.google.gson.annotations.SerializedName

// 1. Root/Pusat Data
data class WeatherResponse(
    @SerializedName("lokasi") val lokasiUmum: Lokasi,
    @SerializedName("data") val dataCuaca: List<ForecastData>
)

// 2. Detail Lokasi (Provinsi, Kab, Kec, Desa)
data class Lokasi(
    val provinsi: String,
    val kotkab: String,
    val kecamatan: String,
    val desa: String,
    val lon: Double,
    val lat: Double,
    val timezone: String
)

// 3. Kontainer Data Cuaca
data class ForecastData(
    @SerializedName("lokasi") val lokasiSpesifik: LokasiDetail,
    // Perhatikan: Ini adalah List di dalam List (Array of Array)
    // Karena BMKG mengelompokkan data per hari
    @SerializedName("cuaca") val cuacaHarian: List<List<CuacaDetail>>
)

// 4. Detail Teknis Lokasi dalam Data
data class LokasiDetail(
    val adm4: String,
    val timezone: String,
    val type: String
)

// 5. Inti Informasi: Detail Kondisi Cuaca per 3 Jam
data class CuacaDetail(
    @SerializedName("datetime") val waktuUtc: String,
    @SerializedName("local_datetime") val waktuLokal: String,
    @SerializedName("t") val suhu: Int,               // Suhu dalam Celsius
    @SerializedName("hu") val kelembapan: Int,        // Kelembapan dalam %
    @SerializedName("ws") val kecepatanAngin: Double, // Wind Speed (penting untuk Karhutla)
    @SerializedName("wd") val arahAngin: String,      // Wind Direction
    @SerializedName("weather_desc") val deskripsi: String, // Contoh: "Hujan Ringan"
    @SerializedName("image") val urlIkon: String,     // Link gambar ikon cuaca (.svg)
    @SerializedName("tp") val curahHujan: Double,     // Rain (penting untuk waspada Banjir)
    @SerializedName("vs_text") val jarakPandang: String // Visibility
)