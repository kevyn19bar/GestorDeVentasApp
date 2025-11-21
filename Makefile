clone:
	git clone https://github.com/Andrew96RR/GestorDeVentasApp.git

gitAA:
	git add . --all

gitLogin:
	git config --global user.email "barajakevyns@gmail.com"
	git config --global user.name "kevyn19bar"

gitCommit:
	git commit -m "myNewCommit"

gitRef:
	git reflog

gorigin:
	git remote add origin https://github.com/Andrew96RR/GestorDeVentasApp.git

pushtoMain:
	git branch -M main
	git push -u origin main

pushtoMainSf:
	git stash push -m "My local changes before pulling main"
	git pull origin main
	git stash pop
	git add .
	git commit -m "Merged remote updates with my local changes"
	git push origin main
	
pushtoBr:
	git checkout -b RamaAR96
	git push -u origin RamaAR96

createRepo:
	gh repo create Andrew96RR/FerSales_Bussiness_app_front --private --source=. --remote=origin --push

checkRemote:
	git remote -v

repoExist:
	git init
	git remote add origin https://github.com/Andrew96RR/GestorDeVentasApp.git
	git pull
	git checkout main -f
	git branch --set-upstream-to origin/main

forcepush1:
	@git add .
	@git commit -m "Local work before merging remote" || echo "No changes to commit"
	@git pull origin main --allow-unrelated-histories || echo "Merge might need manual resolution"

forcepush2:
	@git add .
	@git commit -m "Resolved merge conflicts" || echo "No changes to commit"
	@git push origin main -f

pull1:
	git remote add origin https://github.com/Andrew96RR/GestorDeVentasApp.git
	git pull
	git checkout main -f
	git branch --set-upstream-to origin/main

pull2:
	git status
	git checkout main
	git remote -v
	git fetch origin
	git reset --hard origin/main
	git branch backup-local
	git branch --set-upstream-to=origin/main main
	git log --oneline

pullNB:
	git status
	git checkout main
	git remote -v
	git fetch origin
	git reset --hard origin/main
	git branch backup-local
	git branch --set-upstream-to=origin/main main
	git log --oneline

pullPop:
	git stash push -m "My local changes before pulling main"
	git status
	git checkout main
	git remote -v
	git fetch origin
	git stash pop
	git add .
	git log --oneline

stashAp:
	git stash apply stash@{0}
	git stash pop stash@{0} 


.PHONY: clone gitAA gitLogin gitCommit gitRef gorigin pushtoMain pushtoBr createRepo repoExist pull1 pull2 pullNB stashAp pullPop
