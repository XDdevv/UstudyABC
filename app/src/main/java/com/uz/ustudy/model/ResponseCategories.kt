package uz.ustudy.model

data class ResponseCategories(
    val ok: Boolean = false,
    val categories:List<CategoryDTO>? = null,
    val message: String? = null
)