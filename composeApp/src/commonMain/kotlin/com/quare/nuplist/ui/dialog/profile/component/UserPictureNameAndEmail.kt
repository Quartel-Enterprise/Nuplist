package com.quare.nuplist.ui.dialog.profile.component

import com.quare.nuplist.ui.picture.UserProfilePicture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogState

@Composable
fun UserPictureNameAndEmail(
    user: ProfileDialogState,
    modifier: Modifier = Modifier,
) {
    user.run {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            UserProfilePicture(
                photoUrl = userPicture,
                size = 40.dp
            )
            Column {
                Text(
                    text = userName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
                userEmail?.let {
                    Text(
                        text = it,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
    }
}
