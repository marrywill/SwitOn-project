<template>
	<section class="notification-wrap">
		<span class="nav-router-full router-cursor" @click="isOpen = !isOpen"
			>알림</span
		>
		<i
			@click="isOpen = !isOpen"
			class="icon ion-md-notifications nav-router-medium router-cursor"
			aria-label="알림버튼"
		></i>
		<section
			id="messagesBox"
			:class="[isOpen ? '' : 'messages-close', 'messages-wrap']"
		>
			<ul v-if="messages.length">
				<li :key="message.id" v-for="message in messages">
					<!-- 스케쥴 -->
					<router-link
						v-if="message.type === 1"
						:to="`/study/${message.study_id}`"
					>
						<span @click="readAlarm(message.id)">{{
							message.msg
						}}</span></router-link
					>
					<!-- 내글에 달린거 -->
					<router-link
						v-else-if="message.type === 2"
						:to="
							`/study/${message.study_id}/${message.board_name}/${message.article_id}`
						"
					>
						<span @click="readAlarm(message.id)">{{ message.msg }}</span>
					</router-link>
					<!-- 내 댓글에 좋아요 -->
					<router-link
						v-else-if="message.type === 3"
						:to="
							`/study/${message.study_id}/${message.board_name}/${message.article_id}`
						"
					>
						<span @click="readAlarm(message.id)">{{
							message.msg
						}}</span></router-link
					>
					<!-- 내가 만든 스터디에 누가 가입 -->
					<router-link v-else :to="`/study/${message.study_id}`">
						<span @click="readAlarm(message.id)">{{ message.msg }}</span>
					</router-link>
				</li>
			</ul>
			<div class="messages-not" v-else>
				알림이 없습니다 :(
			</div>
		</section>
	</section>
</template>

<script>
import { readingUserAlarm } from '@/api/auth';
export default {
	props: {
		messages: Array,
	},
	data() {
		return {
			isOpen: false,
		};
	},
	methods: {
		async readAlarm(id) {
			await readingUserAlarm(id);
		},
	},
	watch: {
		$route() {
			this.isOpen = false;
		},
	},
	updated() {
		const messagesBox = document.querySelector('#messagesBox');
		if (window.innerWidth < '769') {
			messagesBox.style.top = `-${messagesBox.offsetHeight + 15}px`;
		}
	},
};
</script>

<style lang="scss">
.notification-wrap {
	display: inline-block;
	position: relative;
}
.messages-wrap {
	padding: 0.5rem 1.5rem;
	background: rgba(255, 255, 255, 1);
	z-index: 1000;
	box-shadow: 0 2px 6px 0 rgba(68, 67, 68, 0.4);
	border-radius: 3px;
	width: 300px;
	position: absolute;
	top: 30px;
	right: 0;
	@media screen and (max-width: 768px) {
		right: 0;
		width: 200px;
	}
	li {
		margin-bottom: 5px;
	}
	span {
		color: rgba(68, 67, 68, 1);
		font-size: $font-light;
		font-weight: normal;
	}
	.messages-not {
		display: flex;
		justify-content: center;
		align-items: center;
	}
}
.messages-close {
	display: none;
}
.router-cursor {
	cursor: pointer;
}
</style>
