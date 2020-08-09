package com.studyfork.sfoide

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.studyfork.sfoide.model.FriendProfile

class FriendProfileViewModel: ViewModel() {
    private val friendRepository = FriendRepository()

    fun getFriendList(page: Int, results: Int, seed: String) : LiveData<List<FriendProfile>> {
        return friendRepository.getFriendList(page, results, seed)
    }
}