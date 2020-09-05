
(ns page
  (:import java.time.LocalDate)
  (:use hiccup.core))

(defn get-render-data []
  {:posts
   [{:title "Test post"
     :date (LocalDate/now)
     :content "This is a test post"}]})

;; Render


(def page-head
  [:head
   [:title "Mayagerar0"]
   [:link {:rel "stylesheet"
           :href "css/index.css"
           :type "text/css"}]])

(defn render-post [{title :title
                    date  :date
                    content :content}]
  [:div {:class "post-div"}
   [:h3
    title
    " "
    [:span {:class "date-span"} (str date)]]
   content])

(def banner
  [:h1 "Mayagerar0"])

(defn build-page [{posts :posts}]
  (html
   [:html
    page-head
    [:body
     banner
     [:div {:class "post-container"}
      [:h2 "Posts"]
      [:hr]
      (map render-post posts)]]]))

;; ---------------

(defn write-page [content]
  (spit "index.html" content))

(defn -main []
  (let [data (get-render-data)
        page (build-page data)]
    (println "Building page...")
    (write-page page)
    (println "Done (:")))


