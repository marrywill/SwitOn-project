<template>
	<section class="main-page">
		<AppHeader :messages="[]"></AppHeader>
		<section class="main-page-description">
			<section class="main-description-title">
				<h1 class="animate__animated animate__zoomOut animate__delay-1s hide">
					Study with Online
				</h1>
				<h1 class="animate__animated animate__zoomIn animate__delay-2s show">
					SwitOn
				</h1>
				<p>온라인에서 함께하는 스터디</p>
			</section>
			<p>
				출석 버튼으로, 나도
				<span>switch on</span
				><i class="icon ion-md-bulb high-light" aria-hidden="true"></i>
			</p>
			<p>
				정보 공유<i
					class="icon ion-md-information exclamation"
					aria-hidden="true"
				></i>
				일정 관리<i
					class="icon ion-md-information exclamation"
					aria-hidden="true"
				></i>
				이력 관리<i
					class="icon ion-md-information exclamation"
					aria-hidden="true"
				></i>
			</p>
			<p>스윗온과 함께 해요 :)</p>
		</section>
	</section>
</template>

<script>
import AppHeader from '@/components/common/AppHeader.vue';
import { mapGetters } from 'vuex';

export default {
	components: {
		AppHeader,
	},
	computed: {
		...mapGetters(['isLogin']),
	},
	mounted() {
		document.title = 'Swit On';
	},
};
</script>

<style lang="scss">
.main-page {
	display: flex;
	flex-direction: column;
	justify-content: space-evenly;
	align-items: center;
	min-height: 100vh;
	max-height: 100%;
	background: $btn-purple-opacity;
	.main-page-description {
		width: 100%;
		min-height: 60vh;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		color: #fff;
		.main-description-title {
			display: grid;
			place-items: center;
			width: 100%;
			margin-bottom: 40px;
			position: relative;
			h1 {
				position: absolute;
				top: -70px;
				font-size: 40px;
			}
		}
		.exclamation {
			margin: 0 10px 0 5px;
			font-size: 1.5rem;
		}
		.high-light {
			margin: 0 5px;
			font-size: 1.8rem;
			animation: change-color 0.5s;
			-webkit-animation: change-color 0.5s;
			animation-delay: 4s;
			animation-fill-mode: forwards;
		}
		@keyframes change-color {
			from {
				color: #fff;
			}
			to {
				color: rgb(255, 217, 0);
			}
		}
		@-webkit-keyframes change-color {
			from {
				color: #fff;
			}
			to {
				color: rgb(255, 217, 0);
			}
		}
	}
}
@media screen and (max-width: 768px) {
	.main-container {
		width: 95%;
	}
	.nav-router {
		width: 100%;
		height: 37px;
		justify-content: space-around;
		position: fixed;
		bottom: 0;
		right: 0;
		z-index: 888;
	}
}
</style>
