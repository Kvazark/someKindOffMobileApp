package com.example.data.repository
import com.example.domain.data.entity.ListButton
import com.example.domain.data.entity.ListElement
import com.example.domain.data.repository.ListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ListRepositoryImpl : ListRepository {
    override suspend fun getList(): List<ListElement> = withContext(Dispatchers.IO) {
        delay(5_000)
        return@withContext listOf(
            ListElement(
                id=0,
                date="26.05.2024",
                image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
                title = "title",
                country = "Russia",
                button = ListButton(
                    title = "Подробнее"
                )
            ),
            ListElement(
                id=1,
                date="27.05.2024",
                image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
                title = "title",
                country = "Russia",
                button = ListButton(
                    title = "Подробнее"
                )
            ),
            ListElement(
                id=2,
                date="05.09.2024",
                image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
                title = "title",
                country = "Russia",
                button = ListButton(
                    title = "Подробнее"
                )
            ),
            ListElement(
                id=3,
                date="31.10.2024",
                image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
                title = "title",
                country = "Russia",
                button = ListButton(
                    title = "Подробнее"
                )
            )
        )
    }

    override suspend fun getElementListById(id: Long): ListElement {
        return ListElement(
            id = 2,
            title = "title",
            date = "05.09.2024",
            country = "Russia",
            image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
            button = ListButton(
                title = "Подробнее"
            )
        )
    }
}