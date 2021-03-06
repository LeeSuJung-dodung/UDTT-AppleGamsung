package com.udtt.applegamsung.ui.intro

import com.udtt.applegamsung.data.repository.TestResultsRepository
import com.udtt.applegamsung.data.repository.UserIdentifyRepository
import com.udtt.applegamsung.util.BaseViewModel
import com.udtt.applegamsung.util.log
import java.util.*

/**
 * Created By Yun Hyeok
 * on 3월 21, 2020
 */

class IntroViewModel(
    private val userIdentifyRepository: UserIdentifyRepository,
    private val testResultsRepository: TestResultsRepository
) : BaseViewModel() {

    var isTestResultEmpty: Boolean = true
        private set

    init {
        loadTestResultIsEmpty()
    }

    fun loadTestResultIsEmpty() {
        testResultsRepository.getTestResults {
            isTestResultEmpty = it.isEmpty()
        }
    }

    fun checkDeviceId() {
        val deviceId = userIdentifyRepository.getDeviceId()
        if (deviceId == null) {
            saveDeviceId(createDeviceId())
        }
        log("device ID : $deviceId")
    }

    private fun createDeviceId(): String = UUID.randomUUID().toString()

    private fun saveDeviceId(deviceId: String) {
        userIdentifyRepository.saveDeviceId(deviceId)
        log("Device Id saved")
    }
}