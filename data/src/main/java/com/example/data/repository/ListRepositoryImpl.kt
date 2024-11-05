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
                image = "https://i.pinimg.com/564x/31/14/91/311491e2c6525c161a13cc208c70d6cf.jpg",
                title = "title",
                subtitle = "subtitle",
                button = ListButton(
                    title = "Подробнее"
                )
            ),
            ListElement(
                id=1,
                date="27.05.2024",
                image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
                title = "title",
                subtitle = "subtitle",
                button = ListButton(
                    title = "Подробнее"
                )
            ),
            ListElement(
                id=2,
                date="05.09.2024",
                image = "https://avatars.mds.yandex.net/i?id=2a00000192f172394f810190aa732b4642dd-467069-fast-images&n=13",
                title = "title",
                subtitle = "Boo",
                button = ListButton(
                    title = "Подробнее"
                )
            ),
            ListElement(
                id=3,
                date="31.10.2024",
                image = "https://i.pinimg.com/564x/a5/75/dc/a575dc4c13fd6a2842d6f08c56b086c9.jpg",
                title = "title",
                subtitle = "subtitle",
                button = ListButton(
                    title = "Подробнее"
                )
            )
        )
    }

    override suspend fun getElementListById(id: Long): ListElement {
        return ListElement(
            id = id,
            title = "title",
            date = "05.09.2024",
            subtitle = "subtitle",
            image = "https://i.pinimg.com/564x/fb/54/06/fb5406326d530c3f5fd1c2be6d7e3c05.jpg",
            button = ListButton(
                title = "Подробнее"
            )
        )
    }
}