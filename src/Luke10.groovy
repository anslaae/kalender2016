/**
 * Created by Roger on 10.12.2016.
 */
def eventyrere = ['trollman':true,'kriger':true,'prest':true,'tyv':true]
def fanger = 17
def log = true
def levendeGoblins = 0
(1..100).each{ goblins ->
    if(log)
        println "Rom " + goblins + " - " + eventyrere
    def drepteGoblins = 0
    def prestFerdig = false
    def drepte = [:]
    while(drepteGoblins<goblins && eventyrere.count{it.value}>0){
        if(eventyrere['tyv'] && drepteGoblins < goblins){
            drepteGoblins++
            if(log)
                println "Tyv dreper goblin"

        }
        if(eventyrere['trollman'] && drepteGoblins < goblins){
            drepteGoblins+=10
            if(log)
                println "Trollman dreper 10 goblin"
        }
        if(eventyrere['kriger'] && drepteGoblins < goblins){
            drepteGoblins++
            if(log)
                println "Kriger dreper goblin"
        }
        if(!prestFerdig && eventyrere['prest'] && drepte['kriger']){
            eventyrere['kriger']=true
            prestFerdig = true
            if(log)
                println "Prest gjennopliver kriger"
        } else if(!prestFerdig && eventyrere['prest'] && drepte['trollman']){
            eventyrere['trollman']=true
            prestFerdig = true
            if(log)
                println "Prest gjennopliver trollman"
        }
        if(eventyrere['tyv'] && !eventyrere['trollman'] && !eventyrere['kriger'] && !eventyrere['prest']){
            if(log)
                println "Tyv stikker av fra " + (goblins-drepteGoblins)
            if(goblins>drepteGoblins)
                levendeGoblins += (goblins-drepteGoblins)
            break
        }
        if(eventyrere['kriger'] && (goblins-drepteGoblins)>=10*eventyrere.count{it.value}){
            if(log)
                println "Goblin dreper kriger"
            eventyrere['kriger']=false
            drepte['kriger']=true
        } else if(eventyrere['trollman'] && (goblins-drepteGoblins)>=10*eventyrere.count{it.value}){
            if(log)
                println "Goblin drepe trollman"
            eventyrere['trollman']=false
            drepte['trollman']=true
        } else if(eventyrere['prest'] && (goblins-drepteGoblins)>=10*eventyrere.count{it.value}){
            if(log)
                println "Goblin drepe prest"
            eventyrere['prest']=false
            drepte['prest']=true
        }
    }
}

println "ferdig: " + eventyrere
println "Levende: " + (fanger + eventyrere.count{it.value} + levendeGoblins)